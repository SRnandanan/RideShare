package com.application.rideshare.models;

public class Bike extends Vehicle{
    public Bike(String numberPlate) {
        super(numberPlate);
    }

    @Override
    public double getFare() {
        return 10;
    }
}
