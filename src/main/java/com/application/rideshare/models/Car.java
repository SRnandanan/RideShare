package com.application.rideshare.models;

public class Car extends Vehicle{


    public Car(String numberPlate) {
        super(numberPlate);
    }

    @Override
    public double getFare() {
        return 20;
    }
}
