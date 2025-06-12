package main.java.com.reservas.services;


public class FlightService implements Service {
    @Override
    public String getDescription() {
        return "Flight Service";
    }

    @Override
    public double getPrice() {
        return 200.0; // Base price for flight service
    }
} 