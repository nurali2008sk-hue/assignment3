package service;

import repository.RentalRepository;
import exception.InvalidInputException;
import exception.DuplicateResourceException;

public class RentalService {

    private RentalRepository repo = new RentalRepository();

    public void rentVehicle(int customerId, int vehicleId, int days)
            throws InvalidInputException {

        if (days <= 0) {
            throw new InvalidInputException("Rental days must be positive");
        }



        repo.create(customerId, vehicleId, days);
    }

    public void cancelRental(int rentalId) {
        repo.delete(rentalId);
    }
}
