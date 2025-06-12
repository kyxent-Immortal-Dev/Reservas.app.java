package main.java.com.reservas.patterns.behavioral;

import main.java.com.reservas.interfaces.PaymentStrategy;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        System.out.println("Procesando pago de $" + amount + " con Tarjeta de Crédito...");
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return "Tarjeta de Crédito";
    }
} 