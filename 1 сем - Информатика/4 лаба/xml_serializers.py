import xmltodict
from schedule import Lesson, Day, Week, Schedule


class SelfWrittenXMLSerializer:
    def __init__(self, schedule: Schedule):
        self._schedule = schedule

    def schedule_to_xml(self):
        xml_str = xmltodict.unparse(dict(self._schedule), pretty=True)
        with open("schedule_lib.xml", "w", encoding="utf-8") as file:
            file.write(xml_str)
