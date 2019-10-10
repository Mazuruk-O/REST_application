package com.gemicle.REST_application.model;

public interface House {
    public String getAddress();

    void setAddress(String address);

    int getNumberEntrances();

    void setNumberEntrances(int numberEntrances);

    int getNumberApartments();

    void setNumberApartments(int numberApartments);

    int getNumberFloors();

    void setNumberFloors(int numberFloors);

    int getYearConstruction();

    void setYearConstruction(int yearConstruction);
}
