package main.java.com.reservas.notifiers;

import main.java.com.reservas.interfaces.Observer;
import main.java.com.reservas.models.Reservation;

public class EmailNotifier implements Observer {
    @Override
    public void update(Reservation reservation) {
        System.out.println("📧 Email enviado a " + reservation.getCustomerName() +
                ": Su reserva ha sido confirmada - ID: " + reservation.getId());
    }

    public void sendEmail(String message) {
        System.out.println("📧 Email notification: " + message);
    }
} 