package service;

import model.Vehicle;
import repository.VehicleRepository;
import exception.InvalidInputException;

public class VehicleService {

    private VehicleRepository repo = new VehicleRepository();

    public void addVehicle(Vehicle vehicle) throws InvalidInputException {

        if (vehicle.getModel() == null || vehicle.getModel().isEmpty()) {
            throw new InvalidInputException("Vehicle model cannot be empty");
        }

        if (vehicle.getPricePerDay() <= 0) {
            throw new InvalidInputException("Price must be greater than zero");
        }

        repo.create(vehicle);
    }
}
