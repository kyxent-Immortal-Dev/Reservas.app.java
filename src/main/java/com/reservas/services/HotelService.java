package main.java.com.reservas.services;



public class HotelService implements Service {
    @Override
    public String getDescription() {
        return "Hotel Service";
    }

    @Override
    public double getPrice() {
        return 100.0; // Base price for hotel service
    }
} 