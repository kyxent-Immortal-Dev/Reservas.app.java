package main.java.com.reservas.interfaces;

public interface PaymentStrategy {
    boolean pay(double amount);
    String getPaymentMethod();
} 