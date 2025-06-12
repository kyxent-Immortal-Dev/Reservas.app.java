package main.java.com.reservas.interfaces;

import main.java.com.reservas.models.Reservation;

public interface Observer {
    void update(Reservation reservation);
} 