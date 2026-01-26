package model;

public abstract class Vehicle {

    protected int id;
    protected String model;
    protected double pricePerDay;

    public Vehicle(int id, String model, double pricePerDay) {
        this.id = id;
        setModel(model);
        setPricePerDay(pricePerDay);
    }

    public abstract String getType();
    public abstract double calculateRentalCost(int days);

    public String getInfo() {
        return model + " costs $" + pricePerDay + " per day";
    }

    public void setModel(String model) {
        if (model == null || model.isEmpty())
            throw new IllegalArgumentException("Model cannot be empty");
        this.model = model;
    }

    public void setPricePerDay(double price) {
        if (price <= 0)
            throw new IllegalArgumentException("Price must be > 0");
        this.pricePerDay = price;
    }

    public String getModel(){
        return model;
    }
    public double getPricePerDay(){
        return pricePerDay;
    }
}