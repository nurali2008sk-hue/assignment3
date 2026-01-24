package model;

public class Truck extends Vehicle {

    public Truck(int id, String model, double pricePerDay) {
        super(id, model, pricePerDay);
    }

    @Override
    public String getType() {
        return "TRUCK";
    }

    @Override
    public double calculateRentalCost(int days) {
        return pricePerDay * days * 1.2;
    }
}