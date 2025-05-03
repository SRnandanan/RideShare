package com.application.rideshare.models;

public abstract class Vehicle {

    protected String numberPlate;


    public Vehicle(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public abstract double getFare();

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

}
