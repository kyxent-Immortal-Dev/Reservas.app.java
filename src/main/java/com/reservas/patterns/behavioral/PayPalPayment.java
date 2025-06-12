package main.java.com.reservas.patterns.behavioral;

import main.java.com.reservas.interfaces.PaymentStrategy;

public class PayPalPayment implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        System.out.println("Procesando pago de $" + amount + " con PayPal...");
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return "PayPal";
    }
} 