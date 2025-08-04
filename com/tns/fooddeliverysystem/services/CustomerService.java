package com.tns.fooddeliverysystem.services;
import com.tns.fooddeliverysystem.entities.Customer;
import java.util.HashMap;
import java.util.Map;
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
