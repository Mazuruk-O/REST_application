package com.gemicle.REST_Application.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.gemicle.REST_application.conf.HouseDeserializer;
import com.gemicle.REST_application.conf.HouseSerializer;
import com.gemicle.REST_application.model.HouseImpl;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

public class JacksonTest {
    private static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();

        module.addDeserializer(HouseImpl.class, new HouseDeserializer()); // register custom Deserializer

        module.addSerializer(HouseImpl.class, new HouseSerializer()); // register custom Serializer

        mapper.registerModule(module);
    }

    @Test
    public void testSerializer() throws JsonProcessingException {
        final String correctSerialized = "{\"address\":\"Soborna\",\"numberEntrances\":5,\"numberApartments\":6,\"numberFloors\":7,\"yearConstruction\":1998,\"typeSerializer\":\"custom\"}";

        final HouseImpl house = new HouseImpl("Soborna",5,6,7,1998);

        final String serialized = mapper.writeValueAsString(house);

        Assert.assertTrue(correctSerialized.equals(correctSerialized));
    }

    @Test
    public void testDeserializer() throws JsonProcessingException {
        final HouseImpl correctHouse = new HouseImpl("Soborna",5,6,7,1998);

        final String stringForDeserialized = "{\"address\":\"Soborna\",\"numberEntrances\":5,\"numberApartments\":6,\"numberFloors\":7,\"yearConstruction\":1998,\"typeSerializer\":\"custom\"}";

        final HouseImpl deserializedHouse = mapper.readValue(stringForDeserialized,HouseImpl.class);

        Assert.assertTrue(correctHouse.equals(deserializedHouse));
    }
}

