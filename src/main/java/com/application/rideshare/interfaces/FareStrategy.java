package com.application.rideshare.interfaces;

import com.application.rideshare.models.Vehicle;

public interface FareStrategy {
    double calcFare(Vehicle vehicle, double distance);
}

