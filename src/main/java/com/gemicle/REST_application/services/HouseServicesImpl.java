package com.gemicle.REST_application.services;

import com.gemicle.REST_application.model.House;
import com.gemicle.REST_application.model.HouseImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class HouseServicesImpl implements HouseServices {
    private List<House> houses = new LinkedList<>();

    public HouseServicesImpl()
    {
        houses.add(new HouseImpl("Soborna 52",5,6,7,1998));
        houses.add(new HouseImpl("Chornovola 88",10,10,9,2012));
        houses.add(new HouseImpl("Kyivska 46",7,8,9,2015));
    }

    @Override
    public House save(House entity) {
        if(!houses.contains(entity)){
            houses.add(entity);
            return entity;
        }

        throw new IllegalArgumentException("HouseServicesImpl.save(House house) - not correct argument!");
    }

    @Override
    public House findByYearConstruction(final Long yearConstruction) {
        return houses.stream()
                .filter(house -> yearConstruction == house.getYearConstruction())
                .findAny()
                .orElse(null);
    }

    @Override
    public House findByAddress(final String address) {
        return houses.stream()
                .filter(house -> address.equals(house.getAddress()))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<House> findAll() {
        return houses;
    }

    @Override
    public void delete(House entity) {
        houses.remove(entity);
    }
}
