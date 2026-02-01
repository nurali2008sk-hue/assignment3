package controller;

import model.*;
import service.*;
import exception.*;

import java.util.Scanner;

public class CarRentalController {

    private CustomerService customerService = new CustomerService();
    private VehicleService vehicleService = new VehicleService();
    private RentalService rentalService = new RentalService();

    private Scanner scanner = new Scanner(System.in);

    public void start() {

        while (true) {
            System.out.println("\n==== CAR RENTAL MENU ====");
            System.out.println("1. Add Customer");
            System.out.println("2. Add Car");
            System.out.println("3. Add Truck");
            System.out.println("4. Rent Vehicle");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1 -> addCustomer();
                    case 2 -> addCar();
                    case 3 -> addTruck();
                    case 4 -> rentVehicle();
                    case 5 -> {
                        System.out.println("Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid option");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void addCustomer() throws InvalidInputException {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        customerService.addCustomer(new Customer(0, name, email));
        System.out.println("Customer added successfully!");
    }

    private void addCar() throws InvalidInputException {
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Price per day: ");
        double price = scanner.nextDouble();


        vehicleService.addVehicle(new Car(0, model, price,null));
        System.out.println("Car added!");
    }

    private void addTruck() throws InvalidInputException {
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Price per day: ");
        double price = scanner.nextDouble();

        vehicleService.addVehicle(new Truck(0, model, price, null));
        System.out.println("Truck added!");
    }

    private void rentVehicle() throws InvalidInputException {
        System.out.print("Customer ID: ");
        int customerId = scanner.nextInt();
        System.out.print("Vehicle ID: ");
        int vehicleId = scanner.nextInt();
        System.out.print("Days: ");
        int days = scanner.nextInt();

        rentalService.rentVehicle(customerId, vehicleId, days);
        System.out.println("Vehicle rented!");
    }
}
