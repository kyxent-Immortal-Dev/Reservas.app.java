package main.java.com.reservas.patterns.structural;

import main.java.com.reservas.interfaces.Service;

public class ServiceDecorator implements Service {
    private Service service;
    private String extra;
    private double extraCost;

    public ServiceDecorator(Service service, String extra) {
        this.service = service;
        this.extra = extra;
        this.extraCost = calculateExtraCost(extra);
    }

    private double calculateExtraCost(String extra) {
        switch (extra.toLowerCase()) {
            case "seguro": return 25.0;
            case "desayuno": return 15.0;
            case "wifi": return 10.0;
            case "equipaje extra": return 30.0;
            default: return 0.0;
        }
    }

    @Override
    public String getDescription() {
        return service.getDescription() + " + " + extra;
    }

    @Override
    public double getPrice() {
        return service.getPrice() + extraCost;
    }
} 