package com.application.rideshare.interfaces;

import com.application.rideshare.models.Vehicle;

public interface FareStrategy {
    double calcFare(Vehicle vehicle, double distance);
}

class StandardFareStrategy implements  FareStrategy {

    @Override
    public double calcFare(Vehicle vehicle, double distance) {
        return vehicle.getFare()*distance;
    }
}

class SharedFareStrategy implements  FareStrategy {

    @Override
    public double calcFare(Vehicle vehicle, double distance) {
        return vehicle.getFare()*distance*0.5;
    }
}

class LuxuryFareStrategy implements  FareStrategy {

    @Override
    public double calcFare(Vehicle vehicle, double distance) {
        return vehicle.getFare()*distance*1.5;
    }
}