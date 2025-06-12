package main.java.com.reservas.patterns.creational;

import main.java.com.reservas.services.Service;
import main.java.com.reservas.services.HotelService;

public class HotelFactory implements ServiceFactory {
    @Override
    public Service createService() {
        return new HotelService();
    }
} 