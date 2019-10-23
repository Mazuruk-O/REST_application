package com.gemicle.REST_application.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.gemicle.REST_application.conf.HouseDeserializer;
import com.gemicle.REST_application.conf.HouseSerializer;

import java.io.Serializable;
import java.util.Objects;

@JsonDeserialize(using = HouseDeserializer.class)
@JsonSerialize(using = HouseSerializer.class)
public class HouseImpl implements House, Serializable {
    private String address;
    private int numberEntrances;
    private int numberApartments;
    private int numberFloors;
    private int yearConstruction;

    public HouseImpl() {
    }

    public HouseImpl(String address, int numberEntrances, int numberApartments, int numberFloors, int yearConstruction) {
        this.address = address;
        this.numberEntrances = numberEntrances;
        this.numberApartments = numberApartments;
        this.numberFloors = numberFloors;
        this.yearConstruction = yearConstruction;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int getNumberEntrances() {
        return numberEntrances;
    }

    @Override
    public void setNumberEntrances(int numberEntrances) {
        this.numberEntrances = numberEntrances;
    }

    @Override
    public int getNumberApartments() {
        return numberApartments;
    }

    @Override
    public void setNumberApartments(int numberApartments) {
        this.numberApartments = numberApartments;
    }

    @Override
    public int getNumberFloors() {
        return numberFloors;
    }

    @Override
    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    @Override
    public int getYearConstruction() {
        return yearConstruction;
    }

    @Override
    public void setYearConstruction(int yearConstruction) {
        this.yearConstruction = yearConstruction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HouseImpl house = (HouseImpl) o;
        return numberEntrances == house.numberEntrances &&
                numberApartments == house.numberApartments &&
                numberFloors == house.numberFloors &&
                yearConstruction == house.yearConstruction &&
                address.equals(house.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, numberEntrances, numberApartments, numberFloors, yearConstruction);
    }

    @Override
    public String toString() {
        return "HouseImpl{" +
                "address='" + address + '\'' +
                ", numberEntrances=" + numberEntrances +
                ", numberApartments=" + numberApartments +
                ", numberFloors=" + numberFloors +
                ", yearConstruction=" + yearConstruction +
                '}';
    }
}
