package com.application.rideshare.services;

import com.application.rideshare.interfaces.FareStrategy;
import com.application.rideshare.models.Driver;
import com.application.rideshare.models.Location;
import com.application.rideshare.models.Passenger;
import com.application.rideshare.models.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class MatchingService {
    private final List<Driver> drivers = new ArrayList<>();
    private final List<Passenger> passengers = new ArrayList<>();


    public void addDriver(Driver d){
        this.drivers.add(d);
    }

    public void addPassenger(Passenger p){
        this.passengers.add(p);
    }

    //Book a ride
    public void bookARide(Passenger p, double distance, FareStrategy strategy){
        if(this.drivers.isEmpty()){
            p.notify("No drivers are available");
            return;
        }


        //find the nearest driver
        Driver assignedDriver = findNearestDriver(p.getLocation());
        p.notify("Ride scheduled succesfully with driver "+assignedDriver.getName());
    }

    private Driver findNearestDriver(Location location) {
        Driver assignedDriver = null;
        double minDistance = Double.MAX_VALUE;
        for(Driver d: drivers){
            double driverDistance = d.getLocation().calcDistanceFromLocation(location);
            if(driverDistance< minDistance){
                minDistance = driverDistance;
                assignedDriver = d;
            }

        }
        return assignedDriver;
    }
}
