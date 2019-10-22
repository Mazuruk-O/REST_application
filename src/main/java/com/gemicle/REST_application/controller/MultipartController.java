package com.gemicle.REST_application.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gemicle.REST_application.model.House;
import com.gemicle.REST_application.model.HouseImpl;
import com.gemicle.REST_application.services.HouseServices;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

@RestController
public class MultipartController {
    private static ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private HouseServices houseServices;

    @PostMapping(value = "/acceptImageAndDataHouse", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public @ResponseBody String uploadImageAndDataHouse(@RequestPart(value = "imgPart") MultipartFile imageFile
                                         , @RequestPart(value = "houseData",required = false) HouseImpl houseData) throws IOException {


        File outputfile = new File("saved.jpeg");

        ImageIO.write(ImageIO.read(imageFile.getInputStream()), "jpeg", outputfile);

        //House houseParseJSON = mapper.readValue(houseData, HouseImpl.class);

        return houseServices.save(houseData).toString();
    }
}
