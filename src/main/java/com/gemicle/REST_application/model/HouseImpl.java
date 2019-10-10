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

    public void setAddress(String address) throws IllegalAccessException {
        if(!(address == null || address.equals("")))
            this.address = address;

        throw new IllegalAccessException("address not correct");
    }

    public int getNumberEntrances() {
        return numberEntrances;
    }

    public void setNumberEntrances(int numberEntrances) throws IllegalAccessException {
        if(isCorrectNumber(numberEntrances))
            this.numberEntrances = numberEntrances;

        new IllegalAccessException("numberEntrances not correct");
    }

    public int getNumberApartments() {
        return numberApartments;
    }

    public void setNumberApartments(int numberApartments) throws IllegalAccessException {
        if(isCorrectNumber(numberApartments))
            this.numberApartments = numberApartments;

        new IllegalAccessException("numberApartments not correct");
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) throws IllegalAccessException {
        if(isCorrectNumber(numberFloors))
            this.numberFloors = numberFloors;

        new IllegalAccessException("numberFloors not correct");
    }

    public int getYearConstruction() {
        return yearConstruction;
    }

    public void setYearConstruction(int yearConstruction) throws IllegalAccessException {
        if(isCorrectNumber(yearConstruction))
            this.yearConstruction = yearConstruction;

        new IllegalAccessException("yearConstruction not correct");
    }

    private boolean isCorrectNumber(int number){
        if(number > 0)
            return true;

        return false;
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
