import os
class Lesson:
    def __init__(self, time, discipline, type, lecturer, classroom):
        self.time = time
        self.discipline = discipline
        self.type = type
        self.lecturer = lecturer
        self.classroom = classroom
    
    
    def __str__(self):
        a = [self.time, self.discipline, self.type, self.lecturer, self.classroom]
        return '\n'.join(a) + '\n\n'

class Day:
    lessons = []

    def add_lesson(self, lesson):
        if type(lesson) is not Lesson:
            raise TypeError
        
        self.lessons.append(lesson)

    def __str__(self):
        return '\n'.join([str(i) for i in self.lessons]) + '\n\n\n\n'

class Week:
    days = []

    def __init__(self, parity_check):
        self.parity_check = parity_check

    def add_day(self, day):
        if type(day) is not Day:
            raise TypeError
        
        self.days.append(day)
    
    def __str__(self):
        a = '\n'.join([str(i) for i in self.days])
        return str(self.parity_check) + '\n' + a + '\n\n\n\n\n\n\n\n'

class Schedule:
    weeks = []
    student_id = -1 

    def __init__(self, student_id):
        self.student_id = student_id

    def add_week(self, week):
        if type(week) is not Week:
            raise TypeError
        
        self.weeks.append(week)
    
    def __str__(self):
        return '\n'.join([str(i) for i in self.weeks])
    
class TOMLDeserialization:
    def _path_validator(self, path):
        if os.path.isfile(path) == False:
            raise FileNotFoundError
    
    def _clear_data(self, data): #! реализовать удаление комментариев
        data = [i.replace('\t', '') for i in data if i.replace('\t', '') != '']
        return data
    
    def _parse_blocks(self, toml_string) -> list[list[str, int, int, list]]: #!нет проверки на закрытие скобок
        bracket_open_index = 0
        bracket_close_index = 0
        blocks = []
        
        for i in range(len(toml_string)):
            s = toml_string[i]

            if s == '[':
                bracket_open_index = i
            elif s == ']':
                bracket_close_index = i
                block_name = toml_string[bracket_open_index + 1 : bracket_close_index]
                blocks.append([block_name, bracket_open_index, bracket_close_index])
        
        for i in range(len(blocks) - 1):
            cur_bracket_close_index = blocks[i][2]
            next_bracket_open_index = blocks[i+1][1]
            block_content = toml_string[cur_bracket_close_index + 1 : next_bracket_open_index]
            block_content = block_content.split('\n')
            
            block_content = self._clear_data(block_content)
            blocks[i].append(block_content)
        
        block_content = toml_string[cur_bracket_close_index + 1 :]
        block_content = block_content.split('\n')
        block_content = self._clear_data(block_content)
        blocks[len(blocks) - 1].append(block_content)

        return blocks        

    def get_schedule(self, path_to_toml_file):
        self._path_validator(path_to_toml_file)

        toml_file = open(path_to_toml_file, 'r', encoding='utf-8') 
        toml_string = toml_file.read()
        blocks = self._parse_blocks(toml_string)

        for block in blocks:
            print(block)
            block_name_dot_counter = block[0].count('.')
            block_content = block[3]

            if block_name_dot_counter == 0:
                schedule = Schedule(block_content)
            elif block_name_dot_counter == 1: #блок недели
                week = Week(block_content)
                schedule.add_week(week)
            elif block_name_dot_counter == 2: #блок дня
                day = Day()
                week.add_day(day)
            elif block_name_dot_counter == 3: #блок урока
                time = block_content[0]
                discipline = block_content[1]
                type = block_content[2]
                lecturer = block_content[3]
                classroom = block_content[4]
                
                lesson = Lesson(time, discipline, type, lecturer, classroom)
                day.add_lesson(lesson)
        return schedule


if __name__ == '__main__':
    path = 'schedule.toml'
    obj = TOMLDeserialization()
    shedule = obj.get_schedule(path) 

    print(shedule)





