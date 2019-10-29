package com.gemicle.REST_application.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gemicle.REST_application.model.House;
import com.gemicle.REST_application.model.HouseDTO;
import com.gemicle.REST_application.model.HouseImpl;
import com.gemicle.REST_application.services.HouseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.print.attribute.standard.MediaSize;
import java.io.File;
import java.io.IOException;

@RestController
public class MultipartController {
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private HouseServices houseServices;

    @PostMapping(value = "/acceptImageAndDataHouse", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadImageAndDataHouse(@RequestPart(value = "imageFile") MultipartFile imageFile
                                         , @RequestPart(value = "houseData",required = false) HouseImpl houseData) throws IOException {


        File outputfile = new File("saved.jpeg");

        ImageIO.write(ImageIO.read(imageFile.getInputStream()), "jpeg", outputfile);

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
                .body(houseServices.save(houseData));
    }

    @PostMapping(value = "/acceptDTOHouse")
    public ResponseEntity<?> acceptDTOHouse(@ModelAttribute HouseDTO houseDTO){
        try {
            File outputfile = new File("savedFromDTO.jpeg");

            ImageIO.write(ImageIO.read(houseDTO.getImageFile().getInputStream()), "jpeg", outputfile);

            houseServices.save(houseDTO.getHouseData());

        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.status(HttpStatus.OK).body(houseServices.save(houseDTO.getHouseData()));
    }

}
