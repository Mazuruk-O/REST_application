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
        houses.add(new HouseImpl("Soborna",5,6,7,1998));
        houses.add(new HouseImpl("Chornovola",10,10,9,2012));
        houses.add(new HouseImpl("Kyivska",7,8,9,2015));
    }

    /**
     *
     * @param entity
     * @return
     */
    @Override
    public House save(House entity) {
        if(!houses.contains(entity)){
            houses.add(entity);
            return entity;
        }

        throw new IllegalArgumentException("HouseServicesImpl.save(House house) - not correct argument!");
    }

    /**
     *
     * @param yearConstruction
     * @return
     */
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
    public void delete(String address) {
        House forDelete = null;

        for(House h : houses){
            if(h.getAddress().equals(address)){
                forDelete = h;
                break;
            }
        }

        if(!(houses == null))
            houses.remove(forDelete);
    }
}
