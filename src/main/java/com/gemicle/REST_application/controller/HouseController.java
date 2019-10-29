package com.gemicle.REST_application.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gemicle.REST_application.model.House;
import com.gemicle.REST_application.model.HouseImpl;
import com.gemicle.REST_application.services.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HouseController {
    @Autowired
    private HouseRepository houseRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/houses")
    List<HouseImpl> allHouse(){
        return houseRepository.findAll();
    }

    @PostMapping("/houses")
    public House newHouse(@RequestBody HouseImpl house){
        return houseRepository.save(house);
    }

    @PutMapping("/houses/{address}")
    House replaceHouse(@RequestBody HouseImpl house) throws IllegalAccessException {

        HouseImpl forReplace = houseRepository.findByAddress(house.getAddress());

        replaceHouseData(forReplace,house);

        return forReplace;
    }

    @DeleteMapping("/houses/{address}")
    void deleteEmployee(@PathVariable String address) {
        houseRepository.delete(houseRepository.findByAddress(address));
    }

    private House replaceHouseData(HouseImpl oldHouseData, HouseImpl newHouseData) throws IllegalAccessException {
        oldHouseData.setNumberApartments(newHouseData.getNumberApartments());
        oldHouseData.setNumberEntrances(newHouseData.getNumberEntrances());
        oldHouseData.setNumberFloors(newHouseData.getNumberFloors());
        oldHouseData.setYearConstruction(newHouseData.getYearConstruction());

        houseRepository.save(oldHouseData);

        return oldHouseData;
    }
}
