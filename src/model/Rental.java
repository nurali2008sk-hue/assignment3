package model;

public class Rental {

    private int id;
    private Customer customer;
    private Vehicle vehicle;
    private int days;

    public Rental(int id, Customer customer, Vehicle vehicle, int days) {
        this.id = id;
        this.customer = customer;
        this.vehicle = vehicle;
        this.days = days;
    }

    public double getTotalPrice() {
        return vehicle.calculateRentalCost(days);
    }
}
