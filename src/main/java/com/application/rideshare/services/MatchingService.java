package com.application.rideshare.services;

import com.application.rideshare.models.Driver;
import com.application.rideshare.models.Location;
import com.application.rideshare.models.Passenger;
import com.application.rideshare.models.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class MatchingService {
    private List<Driver> drivers = new ArrayList<>();
    private List<Passenger> passengers = new ArrayList<>();


    public void addDriver(Driver d){
        this.drivers.add(d);
    }

    public void addPassenger(Passenger p){
        this.passengers.add(p);
    }

    //Book a ride
    public void bookARide(Passenger p, double distance){
        if(this.drivers.isEmpty()){
            System.out.println("No drivers available for "+p.getName());
            return;
        }

        Driver assignedDriver = null;
        double minDistance = Double.MAX_VALUE;

        //find the nearest driver
        for(Driver d: drivers){
            double driverDistance = calcDistance(p.getLocation(), d.getLocation());
            if(driverDistance<minDistance){
                minDistance = driverDistance;
                assignedDriver = d;
            }

        }

        //calculate fare
        assert assignedDriver != null;
        double expectedFare = calcFare(assignedDriver.getVehicle(), distance);
        System.out.println("Assigned "+ p.getName()+ " with driver "+ assignedDriver.getName()+ " with fare "+ expectedFare);


        //notify driver and fare to passenger
    }

    private double calcDistance(Location l1, Location l2){

        return Math.sqrt(
                Math.pow(l1.getLatitude()-l2.getLatitude(), 2) +
                Math.pow(l1.getLongitude()-l2.getLongitude(),2)
        );
    }

    private double calcFare(Vehicle vehicle, double distance){
        if(vehicle.getType().equalsIgnoreCase("Car")) {
            return distance * 20;
        } else if(vehicle.getType().equalsIgnoreCase("Bike")){
            return distance * 10;
        }
        return distance * 8;
    }
}
