package main.java.com.reservas.patterns.behavioral;

import main.java.com.reservas.interfaces.PaymentStrategy;

public class BankTransferPayment implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        System.out.println("Procesando pago de $" + amount + " con Transferencia Bancaria...");
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return "Transferencia Bancaria";
    }
} 