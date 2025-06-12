package main.java.com.reservas.models;

import main.java.com.reservas.services.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;

public class Reservation {
    private static int nextId = 1;
    private int id;
    private String customerName;
    private Service service;
    private LocalDate startDate;
    private LocalDate endDate;
    private String paymentMethod;
    private List<String> extras;
    private LocalDateTime creationTime;

    public Reservation(String customerName, Service service, LocalDate startDate, LocalDate endDate, String paymentMethod) {
        this.id = nextId++;
        this.customerName = customerName;
        this.service = service;
        this.startDate = startDate;
        this.endDate = endDate;
        this.paymentMethod = paymentMethod;
        this.extras = new ArrayList<>();
        this.creationTime = LocalDateTime.now();
    }

    public double getTotalPrice() {
        return service.getPrice();
    }

    public boolean processPayment() {
        return true; // Assuming payment is always successful
    }

    // Getters
    public int getId() { return id; }
    public String getCustomerName() { return customerName; }
    public Service getService() { return service; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public String getPaymentMethod() { return paymentMethod; }
    public List<String> getExtras() { return extras; }
    public LocalDateTime getCreationTime() { return creationTime; }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("ID: %d | Cliente: %s | Servicio: %s | " +
                        "Fechas: %s - %s | Pago: %s | Total: $%.2f",
                id, customerName, service.getDescription(),
                startDate.format(formatter), endDate.format(formatter),
                paymentMethod, getTotalPrice());
    }

    public void setExtras(List<String> extras) {
        this.extras = extras;
    }
} 