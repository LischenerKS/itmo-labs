from toml_deserializators import TOMLDeserializatorFabric
from hcl_serializers import HCLSerializerFabric
from xml_serializers import SelfWrittenXMLSerializer

if __name__ == "__main__":
    path = "schedule.toml"
    my_toml_deserializer_fabric = TOMLDeserializatorFabric()
    my_toml_deserializer = my_toml_deserializer_fabric.get_toml_deserializator("Lib")

    schedule = my_toml_deserializer.toml_to_schedule(path)
    my_hcl_serializer_fabric = HCLSerializerFabric()
    my_hcl_serializer = my_hcl_serializer_fabric.get_hcl_serializer(schedule, "Lib")
    my_hcl_serializer.schedule_to_hcl()

    my_xml_serializer = SelfWrittenXMLSerializer(schedule)
    my_xml_serializer.schedule_to_xml()
