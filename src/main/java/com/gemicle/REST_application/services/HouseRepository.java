package com.gemicle.REST_application.services;

import com.gemicle.REST_application.model.HouseImpl;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HouseRepository extends MongoRepository<HouseImpl, String> {
    HouseImpl findByAddress(String address);
}
