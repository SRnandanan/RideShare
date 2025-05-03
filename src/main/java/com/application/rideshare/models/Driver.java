package com.application.rideshare.models;

public class Driver extends User {

    private Vehicle vehicle;


    public Driver(Vehicle vehicle, Location location, String name) {
        super(name, location);
        this.vehicle = vehicle;
    }


    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
