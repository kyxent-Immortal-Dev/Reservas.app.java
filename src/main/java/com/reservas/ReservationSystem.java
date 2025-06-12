package main.java.com.reservas;

import main.java.com.reservas.notifiers.EmailNotifier;
import main.java.com.reservas.notifiers.SMSNotifier;
import java.util.ArrayList;
import java.util.List;

public class ReservationSystem {
    private static ReservationSystem instance;
    private List<Object> observers;

    private ReservationSystem() {
        observers = new ArrayList<>();
    }

    public static ReservationSystem getInstance() {
        if (instance == null) {
            instance = new ReservationSystem();
        }
        return instance;
    }

    public void addObserver(Object observer) {
        observers.add(observer);
    }

    public void removeObserver(Object observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (Object observer : observers) {
            if (observer instanceof EmailNotifier) {
                ((EmailNotifier) observer).sendEmail(message);
            } else if (observer instanceof SMSNotifier) {
                ((SMSNotifier) observer).sendSMS(message);
            }
        }
    }
} 