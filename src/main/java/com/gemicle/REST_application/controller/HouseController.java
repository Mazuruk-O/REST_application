package com.gemicle.REST_application.controller;

import com.gemicle.REST_application.model.House;
import com.gemicle.REST_application.services.HouseServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HouseController {
    private final HouseServices houseServices;

    public HouseController(HouseServices houseServices) {
        this.houseServices = houseServices;
    }

    @GetMapping("/houses")
    List<House> allHouse(){
        return houseServices.findAll();
    }

    @PostMapping("/houses")
    void newHouse(@RequestBody House house){
        houseServices.save(house);
    }

    @PutMapping("/employees/{address}")
    void replaceHouse(@RequestBody House house){
        houseServices.save(house);
    }

    @DeleteMapping("/employees/{address}")
    void deleteEmployee(@RequestBody House house) {
        houseServices.delete(house);
    }
}
