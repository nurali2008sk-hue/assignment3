package model;

public class Engine {
    private int id;
    private String type;
    private int horsepower;

    public Engine(int id, String type, int horsepower) {
        this.id = id;
        this.type = type;
        this.horsepower = horsepower;
    }

    public int getId() { return id; }
    public String getType() { return type; }
    public int getHorsepower() { return horsepower; }
}
