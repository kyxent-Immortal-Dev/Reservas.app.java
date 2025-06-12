package main.java.com.reservas.services;



public class CarRentalService implements Service {
    @Override
    public String getDescription() {
        return "Car Rental Service";
    }

    @Override
    public double getPrice() {
        return 50.0; // Base price for car rental service
    }
} 