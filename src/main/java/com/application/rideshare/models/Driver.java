package com.application.rideshare.models;

public class Driver {

    private Vehicle vehicle;

    private Location location;

    private String name;

    public Driver(Vehicle vehicle, Location location, String name) {
        this.vehicle = vehicle;
        this.location = location;
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
