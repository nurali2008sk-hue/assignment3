package model;

public class Car extends Vehicle {

    public Car(int id, String model, double pricePerDay) {
        super(id, model, pricePerDay);
    }

    @Override
    public String getType() {
        return "CAR";
    }

    @Override
    public double calculateRentalCost(int days) {
        return pricePerDay * days;
    }
}