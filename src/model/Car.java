package model;

public class Car extends VehicleBase {
    private Engine engine; // composition

    public Car(int id, String name, double pricePerDay, Engine engine) {
        super(id, name, pricePerDay);
        this.engine = engine;
    }

    @Override public String getType() { return "CAR"; }

    @Override public double calculateRentalCost(int days) {
        return getPricePerDay() * days;
    }

    public Engine getEngine() { return engine; }
}


