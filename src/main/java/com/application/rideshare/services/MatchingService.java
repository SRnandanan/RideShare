package com.application.rideshare.services;

import com.application.rideshare.interfaces.FareStrategy;
import com.application.rideshare.models.*;

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
        this.drivers.remove(assignedDriver);

        Ride ride = new Ride(p,assignedDriver,distance,strategy);

        p.notify("Ride scheduled with rupees "+ride.getFare());
        assignedDriver.notify("New ride request with fare "+ride.getFare());

        //change status of ride
        ride.updateStatus(RideStatus.PENDING);

        //Change status of the ride after ride is finished, driver becomes available again

        ride.updateStatus(RideStatus.COMPLETED);
        drivers.add(assignedDriver);
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
