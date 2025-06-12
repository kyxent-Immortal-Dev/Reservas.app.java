package main.java.com.reservas;

import main.java.com.reservas.interfaces.Command;
import main.java.com.reservas.notifiers.EmailNotifier;
import main.java.com.reservas.notifiers.SMSNotifier;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ReservationApp {
    private static Scanner scanner = new Scanner(System.in);
    private static ReservationFacade facade = new ReservationFacade();
    private static List<Command> commandHistory = new ArrayList<>();

    public static void main(String[] args) {
        // Configurar observadores
        ReservationSystem system = ReservationSystem.getInstance();
        system.addObserver(new EmailNotifier());
        system.addObserver(new SMSNotifier());

        System.out.println("🏨 ===== SISTEMA DE RESERVAS EN LÍNEA =====");
        System.out.println("Implementación de Patrones de Diseño");
        System.out.println("==========================================\n");

        boolean running = true;
        while (running) {
            showMenu();
            int option = getIntInput("Seleccione una opción: ");

            switch (option) {
                case 1:
                    createReservation();
                    break;
                case 2:
                    facade.showAllReservations();
                    break;
                case 3:
                    undoLastCommand();
                    break;
                case 4:
                    showPatternInfo();
                    break;
                case 5:
                    running = false;
                    System.out.println("¡Gracias por usar el sistema de reservas!");
                    break;
                default:
                    System.out.println("❌ Opción no válida");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n📋 MENÚ PRINCIPAL");
        System.out.println("1. 🎯 Crear nueva reserva");
        System.out.println("2. 📋 Ver todas las reservas");
        System.out.println("3. ↩️ Deshacer última operación");
        System.out.println("4. 🔍 Información sobre patrones implementados");
        System.out.println("5. 🚪 Salir");
        System.out.println("==========================================");
    }

    private static void createReservation() {
        System.out.println("\n🎯 CREAR NUEVA RESERVA");
        System.out.println("======================");

        String customerName = getStringInput("Nombre del cliente: ");

        System.out.println("\nTipos de servicio disponibles:");
        System.out.println("1. Hotel");
        System.out.println("2. Vuelo (Flight)");
        System.out.println("3. Alquiler de Auto (Car)");
        String serviceType = getServiceType();

        LocalDate startDate = getDateInput("Fecha de inicio (dd/mm/yyyy): ");
        LocalDate endDate = getDateInput("Fecha de fin (dd/mm/yyyy): ");

        System.out.println("\nMétodos de pago:");
        System.out.println("1. Tarjeta de Crédito");
        System.out.println("2. PayPal");
        System.out.println("3. Transferencia Bancaria");
        String paymentMethod = getPaymentMethod();

        List<String> extras = getExtras();

        facade.makeReservation(serviceType, customerName, startDate, endDate, paymentMethod, extras);

        System.out.println("\n✅ ¡Reserva procesada exitosamente!");
        System.out.println("Las notificaciones han sido enviadas.");
    }

    private static String getServiceType() {
        int option = getIntInput("Seleccione tipo de servicio (1-3): ");
        switch (option) {
            case 1: return "hotel";
            case 2: return "flight";
            case 3: return "car";
            default: return "hotel";
        }
    }

    private static String getPaymentMethod() {
        int option = getIntInput("Seleccione método de pago (1-3): ");
        switch (option) {
            case 1: return "tarjeta";
            case 2: return "paypal";
            case 3: return "transferencia";
            default: return "tarjeta";
        }
    }

    private static List<String> getExtras() {
        List<String> extras = new ArrayList<>();
        System.out.println("\n¿Desea agregar servicios extras? (s/n)");
        String response = getStringInput("").toLowerCase();

        if (response.startsWith("s")) {
            System.out.println("Servicios extras disponibles:");
            System.out.println("1. Seguro (+$25)");
            System.out.println("2. Desayuno (+$15)");
            System.out.println("3. WiFi (+$10)");
            System.out.println("4. Equipaje Extra (+$30)");

            String extrasInput = getStringInput("Ingrese números separados por coma (ej: 1,3): ");
            String[] numbers = extrasInput.split(",");

            for (String num : numbers) {
                try {
                    int extraOption = Integer.parseInt(num.trim());
                    switch (extraOption) {
                        case 1: extras.add("Seguro"); break;
                        case 2: extras.add("Desayuno"); break;
                        case 3: extras.add("WiFi"); break;
                        case 4: extras.add("Equipaje Extra"); break;
                    }
                } catch (NumberFormatException e) {
                    // Ignorar entradas inválidas
                }
            }
        }

        return extras;
    }

    private static void undoLastCommand() {
        if (commandHistory.isEmpty()) {
            System.out.println("❌ No hay operaciones para deshacer");
            return;
        }

        Command lastCommand = commandHistory.get(commandHistory.size() - 1);
        lastCommand.undo();
        commandHistory.remove(commandHistory.size() - 1);
    }

    private static void showPatternInfo() {
        System.out.println("\n🔍 PATRONES DE DISEÑO IMPLEMENTADOS");
        System.out.println("===================================");

        System.out.println("\n📁 PATRONES CREACIONALES:");
        System.out.println("• Singleton: ReservationSystem (una sola instancia del sistema)");
        System.out.println("• Factory Method: ServiceFactory (crea diferentes tipos de servicios)");
        System.out.println("• Builder: ReservationBuilder (construye reservas complejas paso a paso)");

        System.out.println("\n🏗️ PATRONES ESTRUCTURALES:");
        System.out.println("• Adapter: HotelAdapter (adapta sistemas legacy)");
        System.out.println("• Facade: ReservationFacade (interfaz simplificada)");
        System.out.println("• Decorator: ServiceDecorator (agrega servicios extras)");

        System.out.println("\n⚡ PATRONES DE COMPORTAMIENTO:");
        System.out.println("• Strategy: PaymentStrategy (diferentes métodos de pago)");
        System.out.println("• Observer: Notificadores (Email y SMS)");
        System.out.println("• Command: CreateReservationCommand (operaciones deshacibles)");

        System.out.println("\nPresione Enter para continuar...");
        scanner.nextLine();
    }

    // Métodos auxiliares para entrada de datos
    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ Por favor ingrese un número válido");
            }
        }
    }

    private static LocalDate getDateInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                return LocalDate.parse(input, formatter);
            } catch (Exception e) {
                System.out.println("❌ Formato de fecha inválido. Use dd/mm/yyyy");
            }
        }
    }
} 