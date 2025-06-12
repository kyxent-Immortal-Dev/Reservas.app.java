# Sistema de Reservas en Línea

Este proyecto es una implementación de un sistema de reservas en consola que utiliza varios patrones de diseño para demostrar buenas prácticas de programación.

## Patrones de Diseño Implementados

### Patrones Creacionales
- **Singleton**: `ReservationSystem` - Asegura una única instancia del sistema de reservas
- **Factory Method**: `ServiceFactory` - Crea diferentes tipos de servicios (hotel, vuelo, auto)
- **Builder**: `ReservationBuilder` - Construye reservas complejas paso a paso

### Patrones Estructurales
- **Adapter**: `HotelAdapter` - Adapta sistemas legacy a la nueva interfaz
- **Facade**: `ReservationFacade` - Proporciona una interfaz simplificada al sistema
- **Decorator**: `ServiceDecorator` - Agrega funcionalidades adicionales a los servicios

### Patrones de Comportamiento
- **Strategy**: `PaymentStrategy` - Implementa diferentes métodos de pago
- **Observer**: `EmailNotifier` y `SMSNotifier` - Notifica sobre cambios en las reservas
- **Command**: `CreateReservationCommand` - Encapsula operaciones como objetos

## Requisitos
- Java 11 o superior
- Maven 3.6 o superior

## Compilación y Ejecución

1. Clonar el repositorio:
```bash
git https://github.com/kyxent-Immortal-Dev/Reservas.app.java.git
cd Reservas.app.java
```

2. Compilar el proyecto:
```bash
mvn clean package
```

3. Ejecutar la aplicación:
```bash
java -jar target/reservas-app-1.0-SNAPSHOT.jar
```

## Estructura del Proyecto

```
src/main/java/com/reservas/
├── interfaces/          # Interfaces del sistema
├── models/             # Clases de modelo
├── services/           # Implementaciones de servicios
├── patterns/           # Patrones de diseño
│   ├── creational/     # Patrones creacionales
│   ├── structural/     # Patrones estructurales
│   └── behavioral/     # Patrones de comportamiento
├── notifiers/          # Implementaciones de notificadores
└── ReservationApp.java # Clase principal
```

## Características
- Reserva de hoteles, vuelos y autos
- Múltiples métodos de pago
- Servicios adicionales (seguro, desayuno, WiFi, etc.)
- Notificaciones por email y SMS
- Operaciones deshacibles
- Interfaz de línea de comandos intuitiva

## Contribuir
Las contribuciones son bienvenidas. Por favor, abre un issue para discutir los cambios propuestos.

## Licencia
Este proyecto está bajo la Licencia MIT. Ver el archivo `LICENSE` para más detalles. 