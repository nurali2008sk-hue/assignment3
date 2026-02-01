package model;

public abstract class VehicleBase {
    private int id;
    private String name;        // model name
    private double pricePerDay;

    protected VehicleBase(int id, String name, double pricePerDay) {
        this.id = id;
        setName(name);
        setPricePerDay(pricePerDay);
    }

    // abstract methods (2)
    public abstract String getType();
    public abstract double calculateRentalCost(int days);

    // concrete method (1)
    public String summary() {
        return getType() + " " + name + " ($" + pricePerDay + "/day)";
    }

    // encapsulation
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPricePerDay() { return pricePerDay; }

    public void setName(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Vehicle name cannot be empty");
        this.name = name;
    }

    public void setPricePerDay(double pricePerDay) {
        if (pricePerDay <= 0) throw new IllegalArgumentException("Price per day must be > 0");
        this.pricePerDay = pricePerDay;
    }
}
