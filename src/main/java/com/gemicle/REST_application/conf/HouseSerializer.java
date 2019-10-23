package com.gemicle.REST_application.conf;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.gemicle.REST_application.model.HouseImpl;

import java.io.IOException;

public class HouseSerializer extends JsonSerializer<HouseImpl> {
    @Override
    public void serialize(HouseImpl house, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("address", house.getAddress());
        jsonGenerator.writeNumberField("numberEntrances", house.getNumberEntrances());
        jsonGenerator.writeNumberField("numberApartments", house.getNumberApartments());
        jsonGenerator.writeNumberField("numberFloors", house.getNumberFloors());
        jsonGenerator.writeNumberField("yearConstruction", house.getYearConstruction());
        jsonGenerator.writeStringField("typeSerializer", "custom");
        jsonGenerator.writeEndObject();
    }
}
