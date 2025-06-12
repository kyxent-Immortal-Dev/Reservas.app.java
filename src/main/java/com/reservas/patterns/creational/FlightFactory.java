package main.java.com.reservas.patterns.creational;

import main.java.com.reservas.services.Service;
import main.java.com.reservas.services.FlightService;

public class FlightFactory implements ServiceFactory {
    @Override
    public Service createService() {
        return new FlightService();
    }
} 