package main.java.com.reservas.patterns.creational;

import main.java.com.reservas.services.Service;
import main.java.com.reservas.services.HotelService;
import main.java.com.reservas.services.FlightService;
import main.java.com.reservas.services.CarRentalService;

public class ServiceFactoryImpl implements ServiceFactory {
    private String serviceType;

    public ServiceFactoryImpl(String serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public Service createService() {
        switch (serviceType.toLowerCase()) {
            case "hotel":
                return new HotelService();
            case "flight":
                return new FlightService();
            case "car":
                return new CarRentalService();
            default:
                throw new IllegalArgumentException("Invalid service type: " + serviceType);
        }
    }
} 