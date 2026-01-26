package service;

import model.Customer;
import repository.CustomerRepository;
import exception.InvalidInputException;

public class CustomerService {

    private CustomerRepository repo = new CustomerRepository();

    public void addCustomer(Customer customer) throws InvalidInputException {

        if (customer.getName() == null || customer.getName().isEmpty()) {
            throw new InvalidInputException("Customer name cannot be empty");
        }

        if (!customer.getEmail().contains("@")) {
            throw new InvalidInputException("Invalid email format");
        }

        repo.create(customer);
    }
}
