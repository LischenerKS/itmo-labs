from abc import ABC, abstractmethod
from pytfvars import tfvars
from schedule import Lesson, Day, Week, Schedule


class HCLSerializerFabric:
    def get_hcl_serializer(self, schedule, serializer_type):
        if serializer_type == "SelfWritten":
            return SelfWrittenHCLSerializer(schedule)
        elif serializer_type == "Lib":
            return LibHCLSerializer(schedule)


class AbstractHCLSerializer(ABC):
    def __init__(self, schedule: Schedule):
        self._schedule = schedule

    @abstractmethod
    def schedule_to_hcl(self):
        pass


class SelfWrittenHCLSerializer(AbstractHCLSerializer):
    def __init__(self, schedule: Schedule):
        self._schedule = schedule

    def schedule_to_hcl(self):
        result_string = '"schedule" = {\n'
        result_string += f'  "id" = "{self._schedule.get_student_id()}"\n\n'

        for week in self._schedule.get_weeks():
            result_string += f'  "{week.get_week_name()}" = ' + "{\n"
            result_string += f'    "parity_check" = "{week.get_parity_check()}"\n\n'

            for day in week.get_days():
                day_name = day.get_day_name()
                for lesson in day.get_lessons():
                    result_string += (
                        f'    "{day_name}" "{lesson.get_lesson_number()}" ' + "{\n"
                    )
                    result_string += f'      "classroom" = "{lesson.get_classroom()}"\n'
                    result_string += (
                        f'      "discipline" = "{lesson.get_discipline()}"\n'
                    )
                    result_string += f'      "lecturer" = "{lesson.get_lecturer()}"\n'
                    result_string += f'      "time" = "{lesson.get_time()}"\n'
                    result_string += f'      "type" = "{lesson.get_type()}"\n'
                    result_string += "    }\n"
            result_string += "  }\n"
        result_string += "}"

        with open("schedule_self_written.hcl", "w", encoding="utf-8") as file:
            file.write(result_string)


class LibHCLSerializer(AbstractHCLSerializer):
    def __init__(self, schedule: Schedule):
        self._schedule = schedule

    def schedule_to_hcl(self):
        schedule_dict = dict(self._schedule)
        hcl_str = tfvars.convert(schedule_dict)
        with open("schedule_lib.hcl", "w", encoding="utf-8") as file:
            file.write(hcl_str)
