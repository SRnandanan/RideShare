package com.application.rideshare.interfaces;

import com.application.rideshare.models.Vehicle;

public class LuxuryFareStrategy implements  FareStrategy {

    @Override
    public double calcFare(Vehicle vehicle, double distance) {
        return vehicle.getFare()*distance*1.5;
    }
}
