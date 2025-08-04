package com.tns.fooddeliverysystem.services;
<<<<<<< HEAD

import com.tns.fooddeliverysystem.entities.Customer;
import java.util.HashMap;
import java.util.Map;

=======
>>>>>>> 9b63b36 (initial commit)
public class CustomerService {
    private Map<Integer, Customer> customers = new HashMap<>();

    public void addCustomer(Customer customer) {
        customers.put(customer.getUserId(), customer);
        System.out.println("Customer created successfully!");
    }

    public Customer getCustomerById(int customerId) {
        return customers.get(customerId);
    }

    public Map<Integer, Customer> getAllCustomers() {
        return customers;
    }
}
