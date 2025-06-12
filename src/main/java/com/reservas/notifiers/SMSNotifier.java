package main.java.com.reservas.notifiers;

import main.java.com.reservas.interfaces.Observer;
import main.java.com.reservas.models.Reservation;

public class SMSNotifier implements Observer {
    @Override
    public void update(Reservation reservation) {
        System.out.println("📱 SMS enviado a " + reservation.getCustomerName() +
                ": Reserva confirmada. Total: $" + reservation.getTotalPrice());
    }

    public void sendSMS(String message) {
        System.out.println("📱 SMS notification: " + message);
    }
} 