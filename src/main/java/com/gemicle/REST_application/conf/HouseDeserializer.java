package com.gemicle.REST_application.conf;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.gemicle.REST_application.model.House;
import com.gemicle.REST_application.model.HouseImpl;

import java.io.IOException;

public class HouseDeserializer extends JsonDeserializer<HouseImpl> {
    @Override
    public HouseImpl deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);

        final String address = node.get("address").asText();
        final int numberEntrances = node.get("numberEntrances").asInt();
        final int numberApartments = node.get("numberApartments").asInt();
        final int numberFloors = node.get("numberFloors").asInt();
        final int yearConstruction = node.get("yearConstruction").asInt();

        return new HouseImpl(address,numberEntrances,numberApartments,numberFloors,yearConstruction);
    }
}
