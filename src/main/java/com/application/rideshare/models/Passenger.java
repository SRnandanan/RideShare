package com.application.rideshare.models;

public class Passenger extends User{


    public Passenger(String name, Location location) {
        super(name, location);
    }

    public void notify(String message){
        System.out.println(message);
    }

}
