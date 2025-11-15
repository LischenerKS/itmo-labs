import os
from abc import ABC, abstractmethod
from schedule import Lesson, Day, Week, Schedule

class TOMLDeserializatorFabric:
    def get_toml_deserializator(self, deserializator_type):
        if deserializator_type == "SelfWritten":
            return SelfWrittenTOMLDeserializator()
        elif deserializator_type == "Lib":
            return LibTOMLDeserializator()

        return None


class AbstractTOMLDeserializator(ABC):
    @abstractmethod
    def toml_to_schedule(self, path_to_toml_file):
        pass


class SelfWrittenTOMLDeserializator(AbstractTOMLDeserializator):
    def _path_validator(self, path):
        if not os.path.isfile(path):
            raise FileNotFoundError

    def _delete_empty_elements(self, data):
        return [el for el in data if el != ""]

    def _getvalues_from_key_value_pairs(self, lesson):
        for key_value_pair_id in range(len(lesson)):
            key_value_pair = lesson[key_value_pair_id]

            second_quotation_mark_id = -1
            first_quotation_mark = 10**10

            for s_id in range(len(key_value_pair) - 1, -1, -1):
                s = key_value_pair[s_id]
                if (second_quotation_mark_id == -1) and s == '"':
                    # последняя скобка еще не закрыта
                    second_quotation_mark_id = s_id
                elif (second_quotation_mark_id != -1) and s == '"':
                    # последняя скобка закрыта и мы нашли первую
                    first_quotation_mark = s_id
                    break
            new_key_value_pair = key_value_pair[
                first_quotation_mark + 1 : second_quotation_mark_id
            ]
            lesson[key_value_pair_id] = new_key_value_pair
        return lesson

    def _remove_comments(self, lesson):
        for key_value_pair_id in range(len(lesson)):
            key_value_pair = lesson[key_value_pair_id]
            is_bracket_open = False
            i = len(key_value_pair) - 1

            first_hash_in_key_value_pair_id = len(key_value_pair)

            while (not is_bracket_open) and i >= 0:
                if key_value_pair[i] == '"':
                    is_bracket_open = True
                elif key_value_pair[i] == "#":
                    first_hash_in_key_value_pair_id = i
                i -= 1

            new_key_value_pair = key_value_pair[:first_hash_in_key_value_pair_id]

            lesson[key_value_pair_id] = new_key_value_pair
        return lesson

    def _remove_tabs(self, data: list[str]) -> list[str]:
        data = [i.replace("\t", "") for i in data if i.replace("\t", "") != ""]
        return data

    def _clear_data(self, data):
        data = self._remove_tabs(data)
        data = self._remove_comments(data)
        data = self._getvalues_from_key_value_pairs(data)
        data = self._delete_empty_elements(data)

        return data

    def _parse_blocks(self, toml_string):
        bracket_open_index = 0
        bracket_close_index = 0
        blocks = []

        for i in range(len(toml_string)):
            s = toml_string[i]

            if s == "[":
                bracket_open_index = i
            elif s == "]":
                bracket_close_index = i
                block_name = toml_string[bracket_open_index + 1 : bracket_close_index]
                blocks.append([block_name, bracket_open_index, bracket_close_index])

        for i in range(len(blocks) - 1):
            cur_bracket_close_index = blocks[i][2]
            next_bracket_open_index = blocks[i + 1][1]
            block_content = toml_string[
                cur_bracket_close_index + 1 : next_bracket_open_index
            ]
            block_content = block_content.split("\n")

            block_content = self._clear_data(block_content)
            blocks[i].append(block_content)

        block_content = toml_string[bracket_close_index + 1 :]
        block_content = block_content.split("\n")
        block_content = self._clear_data(block_content)
        blocks[len(blocks) - 1].append(block_content)
        return blocks

    def toml_to_schedule(self, path_to_toml_file):
        self._path_validator(path_to_toml_file)

        toml_file = open(path_to_toml_file, "r", encoding="utf-8")
        toml_string = toml_file.read()
        blocks = self._parse_blocks(toml_string)

        for block in blocks:
            block_name_dot_counter = block[0].count(".")
            block_content = block[3]

            if block_name_dot_counter == 0:
                current_schedule = Schedule(int(block_content[0]))
            elif block_name_dot_counter == 1:  # блок недели
                current_week = Week(block_content[0], block[0].split(".")[1])

                current_schedule.add_week(current_week)
            elif block_name_dot_counter == 2:  # блок дня
                current_day = Day(block[0].split(".")[2])
                current_week.add_day(current_day)
            elif block_name_dot_counter == 3:  # блок урока
                time = block_content[0]
                discipline = block_content[1]
                type = block_content[2]
                lecturer = block_content[3]
                classroom = block_content[4]
                lesson_number = block[0].split(".")[3]

                lesson = Lesson(
                    time, discipline, type, lecturer, classroom, lesson_number
                )
                current_day.add_lesson(lesson)
        return current_schedule


class LibTOMLDeserializator(AbstractTOMLDeserializator):
    def toml_to_schedule(self, path_to_toml_file):
        toml_dict = toml.load(path_to_toml_file)
        # print(toml_dict)
        schedule = Schedule(toml_dict["schedule"]["id"])

        week_names = list(toml_dict["schedule"].keys())
        week_content = list(toml_dict["schedule"].values())
        # print(week_names)
        # print(week_content)
        for i in range(len(week_content)):
            if week_content[i] == schedule.get_student_id():  # пропускаем id
                continue

            week = Week(
                week_name=week_names[i], parity_check=week_content[i]["parity_check"]
            )
            schedule.add_week(week)

            days_names = list(week_content[i].keys())
            days_content = list(week_content[i].values())
            # print(days_names, days_content)
            for j in range(len(days_content)):
                if (
                    days_content[j] == week.get_parity_check()
                ):  # пропускаем parity_check
                    continue

                day = Day(days_names[j])
                week.add_day(day)

                lessons_names = list(days_content[j].keys())
                lessons_content = list(days_content[j].values())
                # print(lessons_names, lessons_content)
                for k in range(len(lessons_content)):
                    time = lessons_content[k]["time"]
                    discipline = lessons_content[k]["discipline"]
                    type_ = lessons_content[k]["type"]
                    lecturer = lessons_content[k]["lecturer"]
                    classroom = lessons_content[k]["classroom"]
                    lesson_number = lessons_names[k]

                    lesson = Lesson(
                        time, discipline, type_, lecturer, classroom, lesson_number
                    )
                    day.add_lesson(lesson)
        return schedule
