package com.gemicle.REST_application.controller;

import com.gemicle.REST_application.model.House;
import com.gemicle.REST_application.model.HouseImpl;
import com.gemicle.REST_application.services.HouseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HouseController {
    @Autowired
    private HouseServices houseServices;

    @GetMapping("/houses")
    List<House> allHouse(){
        return houseServices.findAll();
    }

    @PostMapping("/houses")
    House newHouse(@RequestBody House house){
        return houseServices.save(house);
    }

    @PutMapping("/employees/{address}")
    House replaceHouse(@RequestBody House house){
        try {

            House forReplace = houseServices.findByAddress(house.getAddress());

            return replaceHouseData(forReplace,house);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return new HouseImpl();
    }

    @DeleteMapping("/employees/{address}")
    void deleteEmployee(@RequestBody House house) {
        houseServices.delete(house);
    }

    private House replaceHouseData(House oldHouseData, House newHouseData) throws IllegalAccessException {
        oldHouseData.setNumberApartments(newHouseData.getNumberApartments());
        oldHouseData.setNumberEntrances(newHouseData.getNumberEntrances());
        oldHouseData.setNumberFloors(newHouseData.getNumberFloors());
        oldHouseData.setYearConstruction(newHouseData.getYearConstruction());

        return oldHouseData;
    }
}
