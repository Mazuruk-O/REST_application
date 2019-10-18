package com.gemicle.REST_application.exception;

public class HouseException extends RuntimeException {
    public HouseException(String address){
        super("Could not find employee " + address);
    }
}
