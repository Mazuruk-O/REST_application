package com.gemicle.REST_application.model;

import java.io.Serializable;
import java.util.Objects;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberEntrances() {
        return numberEntrances;
    }

    public void setNumberEntrances(int numberEntrances) {
        this.numberEntrances = numberEntrances;
    }

    public int getNumberApartments() {
        return numberApartments;
    }

    public void setNumberApartments(int numberApartments) {
        this.numberApartments = numberApartments;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    public int getYearConstruction() {
        return yearConstruction;
    }

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
