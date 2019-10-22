package com.gemicle.REST_application.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

public class HouseDTO {
    private MultipartFile imageFile;
    private HouseImpl houseData;

    public HouseDTO() {
    }

    public HouseDTO(MultipartFile imageFile, HouseImpl houseData) {
        this.imageFile = imageFile;
        this.houseData = houseData;
    }

    public MultipartFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }

    public HouseImpl getHouseData() {
        return houseData;
    }

    public void setHouseData(HouseImpl houseData) {
        this.houseData = houseData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HouseDTO houseDTO = (HouseDTO) o;
        return Objects.equals(imageFile, houseDTO.imageFile) &&
                Objects.equals(houseData, houseDTO.houseData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imageFile, houseData);
    }
}
