package com.gemicle.REST_application.model;

public interface House {
    public String getAddress();

    void setAddress(String address) throws IllegalAccessException;

    int getNumberEntrances();

    void setNumberEntrances(int numberEntrances) throws IllegalAccessException;

    int getNumberApartments();

    void setNumberApartments(int numberApartments) throws IllegalAccessException;

    int getNumberFloors();

    void setNumberFloors(int numberFloors) throws IllegalAccessException;

    int getYearConstruction();

    void setYearConstruction(int yearConstruction) throws IllegalAccessException;
}
