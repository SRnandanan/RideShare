package com.application.rideshare.models;

public class Location {

    double latitude;
    double longitude;

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double calcDistanceFromLocation(Location l2){

        return Math.sqrt(
                Math.pow(this.getLatitude()-l2.getLatitude(), 2) +
                        Math.pow(this.getLongitude()-l2.getLongitude(),2)
        );
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
