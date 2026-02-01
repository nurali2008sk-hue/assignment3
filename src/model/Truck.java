package model;

public class Truck extends VehicleBase {
    private Engine engine;

    public Truck(int id, String name, double pricePerDay, Engine engine) {
        super(id, name, pricePerDay);
        this.engine = engine;
    }

    @Override public String getType() { return "TRUCK"; }

    @Override public double calculateRentalCost(int days) {
        return getPricePerDay() * days * 1.2;
    }

    public Engine getEngine() { return engine; }
}
