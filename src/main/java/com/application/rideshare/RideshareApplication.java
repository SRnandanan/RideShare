package com.application.rideshare;

import com.application.rideshare.interfaces.LuxuryFareStrategy;
import com.application.rideshare.interfaces.StandardFareStrategy;
import com.application.rideshare.models.*;
import com.application.rideshare.services.MatchingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RideshareApplication {

	public static void main(String[] args) {
		Location loc1 = new Location(1.12, 3.45);
		Location loc2 = new Location(5.67, 98.12);
		Location loc3 = new Location(5.33, 45.12);

		Vehicle v = new Car("87jkjd");
		Vehicle v2 = new Bike("ujnbkj987");


		Driver d1 = new Driver(v, loc2, "bob");
		Driver d2 = new Driver(v2, loc3, "alice");
		Passenger p = new Passenger("Jill", loc1);

		MatchingService service = new MatchingService();

		service.addPassenger(p);

		service.bookARide(p, 30.0, new StandardFareStrategy());
		service.addDriver(d1);
		service.addDriver(d2);

		service.bookARide(p, 40.0, new LuxuryFareStrategy());



	}

}
