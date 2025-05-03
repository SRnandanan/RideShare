package com.application.rideshare.models;

import com.application.rideshare.interfaces.FareStrategy;

public class Ride {
    private Passenger passenger;
    private Driver driver;
    private double distance;
    private FareStrategy fareStrategy;
    private double fare;
    private RideStatus rideStatus;

    public Ride(Passenger passenger, Driver driver, double distance, FareStrategy fareStrategy) {
        this.passenger = passenger;
        this.driver = driver;
        this.distance = distance;
        this.fareStrategy = fareStrategy;
        this.rideStatus = RideStatus.SCHEDULED;
        notifyUsers(this.rideStatus);
        this.fare = calculateFare();
    }

    public double calculateFare() {
        return fareStrategy.calcFare(driver.getVehicle(), distance);
    }

    public void updateStatus(RideStatus status){
        this.rideStatus = status;
        notifyUsers(status);
    }

    private void notifyUsers(RideStatus status) {
        passenger.notify("Passenger: Your ride is "+status);
        driver.notify("Driver: Ride status is "+status);
    }

    public double getFare() {
        return fare;
    }
}
