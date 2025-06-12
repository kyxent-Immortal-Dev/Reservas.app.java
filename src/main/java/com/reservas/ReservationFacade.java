package main.java.com.reservas;

import main.java.com.reservas.models.Reservation;
import main.java.com.reservas.patterns.creational.ServiceFactory;
import main.java.com.reservas.patterns.creational.HotelFactory;
import main.java.com.reservas.patterns.creational.FlightFactory;
import main.java.com.reservas.patterns.creational.CarRentalFactory;
import main.java.com.reservas.services.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservationFacade {
    private List<Reservation> reservations;

    public ReservationFacade() {
        reservations = new ArrayList<>();
    }

    public void makeReservation(String serviceType, String customerName, 
                              LocalDate startDate, LocalDate endDate, 
                              String paymentMethod, List<String> extras) {
        ServiceFactory factory = getFactoryForServiceType(serviceType);
        Service service = factory.createService();
        Reservation reservation = new Reservation(customerName, service, startDate, endDate, paymentMethod);
        reservation.setExtras(extras);
        reservations.add(reservation);
        
        // Notify observers
        ReservationSystem.getInstance().notifyObservers(
            "New reservation created for " + customerName + " - " + service.getDescription()
        );
    }

    private ServiceFactory getFactoryForServiceType(String serviceType) {
        switch (serviceType.toLowerCase()) {
            case "hotel":
                return new HotelFactory();
            case "flight":
                return new FlightFactory();
            case "car":
                return new CarRentalFactory();
            default:
                throw new IllegalArgumentException("Invalid service type: " + serviceType);
        }
    }

    public void showAllReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No hay reservas registradas.");
            return;
        }

        System.out.println("\n📋 LISTA DE RESERVAS");
        System.out.println("===================");
        for (Reservation reservation : reservations) {
            System.out.println("\nCliente: " + reservation.getCustomerName());
            System.out.println("Servicio: " + reservation.getService().getDescription());
            System.out.println("Fecha inicio: " + reservation.getStartDate());
            System.out.println("Fecha fin: " + reservation.getEndDate());
            System.out.println("Método de pago: " + reservation.getPaymentMethod());
            if (!reservation.getExtras().isEmpty()) {
                System.out.println("Extras: " + String.join(", ", reservation.getExtras()));
            }
            System.out.println("Precio total: $" + reservation.getService().getPrice());
            System.out.println("-------------------");
        }
    }
} 