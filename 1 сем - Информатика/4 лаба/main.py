import time

from toml_deserializators import TOMLDeserializatorFabric
from hcl_serializers import HCLSerializerFabric
from xml_serializers import SelfWrittenXMLSerializer


class TimeComparatorFacade:
    """
    Класс для сравнения времени многократного выполнения десериализации + сериализации отдного типа
    """

    def compare_toml_to_hcl(self, first_type, second_type, executions_counter):
        """
        Создает десереализатор и сериализатор первого типа и исполняет executions_counter раз,
        потом создает десереализатор и сериализатор второго типа и исполняет executions_counter раз.
        Печатает результат сравнения времени исполнения
        """
        for t in first_type, second_type:
            my_toml_deserializer_fabric = TOMLDeserializatorFabric()
            my_hcl_serializer_fabric = HCLSerializerFabric()
            start_time = time.time()
            for i in range(executions_counter):
                my_toml_deserializer = (
                    my_toml_deserializer_fabric.get_toml_deserializator(t)
                )
                schedule = my_toml_deserializer.toml_to_schedule(path)
                my_hcl_serializer = my_hcl_serializer_fabric.get_hcl_serializer(
                    schedule, t
                )
                my_hcl_serializer.schedule_to_hcl()
            end_time = time.time()
            execution_time = end_time - start_time
            print(f"Тип {t} исполнился {executions_counter} раз за {execution_time}")


if __name__ == "__main__":
    path = "schedule.toml"
    my_toml_deserializer_fabric = TOMLDeserializatorFabric()
    my_toml_deserializer = my_toml_deserializer_fabric.get_toml_deserializator(
        "SelfWritten"
    )

    schedule = my_toml_deserializer.toml_to_schedule(path)
    my_hcl_serializer_fabric = HCLSerializerFabric()
    my_hcl_serializer = my_hcl_serializer_fabric.get_hcl_serializer(
        schedule, "SelfWritten"
    )
    my_hcl_serializer.schedule_to_hcl()

    my_xml_serializer = SelfWrittenXMLSerializer(schedule)
    my_xml_serializer.schedule_to_xml()

    my_time_comparator = TimeComparatorFacade()
    my_time_comparator.compare_toml_to_hcl("SelfWritten", "Lib", 100)
