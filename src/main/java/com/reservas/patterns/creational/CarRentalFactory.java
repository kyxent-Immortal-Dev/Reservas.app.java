package main.java.com.reservas.patterns.creational;

import main.java.com.reservas.services.Service;
import main.java.com.reservas.services.CarRentalService;

public class CarRentalFactory implements ServiceFactory {
    @Override
    public Service createService() {
        return new CarRentalService();
    }
} 