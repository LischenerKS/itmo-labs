class Lesson:
    def __init__(self, time, discipline, type, lecturer, classroom, lesson_number):
        self._time = time
        self._discipline = discipline
        self._type = type
        self._lecturer = lecturer
        self._classroom = classroom
        self._lesson_number = lesson_number

    def __iter__(self):
        yield "time", self._time
        yield "discipline", self._discipline
        yield "type", self._type
        yield "lecturer", self._lecturer
        yield "classroom", self._classroom
        yield "lesson_number", self._lesson_number

    def get_time(self):
        return self._time

    def get_discipline(self):
        return self._discipline

    def get_type(self):
        return self._type

    def get_lecturer(self):
        return self._lecturer

    def get_classroom(self):
        return self._classroom

    def get_lesson_number(self):
        return self._lesson_number

    def __str__(self):
        a = [self._time, self._discipline, self._type, self._lecturer, self._classroom]
        return "\n".join(a) + "\n\n"


class Day:
    def __init__(self, day_name):
        self.day_name = day_name
        self._lessons = []

    def get_lessons(self):
        return self._lessons

    def get_day_name(self):
        return self.day_name

    def add_lesson(self, lesson):
        if type(lesson) is not Lesson:
            raise TypeError

        self._lessons.append(lesson)

    def __iter__(self):
        yield "day_name", self.day_name
        yield "lessons", [dict(l) for l in self._lessons]

    def __str__(self):
        starting_message = f"_DAY_\nday_name - {self.day_name}\n"
        content = "\n".join([str(i) for i in self._lessons]) + "\n\n\n\n"
        return starting_message + content

    def __iter__(self):
        yield "day_name", self.day_name
        yield "lessons", [dict(l) for l in self._lessons]


class Week:
    def __init__(self, parity_check, week_name):
        self._parity_check = parity_check
        self._week_name = week_name
        self._days = []

    def get_days(self):
        return self._days

    def get_parity_check(self):
        return self._parity_check

    def get_week_name(self):
        return self._week_name

    def add_day(self, day):
        if type(day) is not Day:
            raise TypeError

        self._days.append(day)

    def __iter__(self):
        yield "parity_check", self._parity_check
        yield "week_name", self._week_name
        yield "days", [dict(d) for d in self._days]

    def __str__(self):
        starting_message = f"__WEEK__\nparity_check = {self._parity_check}\nweek_name = {self._week_name}"
        content = "\n".join([str(i) for i in self._days])
        return starting_message + "\n" + content + "\n\n\n\n\n\n\n\n"


class Schedule:
    _weeks = []
    _student_id = -1

    def __init__(self, student_id):
        self._student_id = student_id

    def add_week(self, week):
        if type(week) is not Week:
            raise TypeError

        self._weeks.append(week)

    def get_student_id(self):
        return self._student_id

    def get_weeks(self):
        return self._weeks

    def __str__(self):
        starting_message = f"___SCHEDULE___\nstudent_id = {self._student_id}\n"

        content = "\n".join([str(i) for i in self._weeks])
        return starting_message + content

    def __iter__(self):
        yield (
            "schedule",
            {"student_id": self._student_id, "weeks": [dict(w) for w in self._weeks]},
        )
