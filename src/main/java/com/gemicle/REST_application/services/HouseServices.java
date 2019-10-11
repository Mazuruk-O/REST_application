package com.gemicle.REST_application.services;

import com.gemicle.REST_application.model.House;

import java.util.List;

public interface HouseServices {
    House save(House entity);

    House findByYearConstruction(Long yearConstruction);

    House findByAddress(String address);

    List<House> findAll();

    void delete(House entity);
}
