
package com.tns.fooddeliverysystem.services;
import com.tns.fooddeliverysystem.entities.Customer;
import com.tns.fooddeliverysystem.entities.DeliveryPerson;
import com.tns.fooddeliverysystem.entities.FoodItem;
import com.tns.fooddeliverysystem.entities.Order;

import java.util.HashMap;
import java.util.Map;

public class OrderService {
    private Map<Integer, Order> orders = new HashMap<>();
    private Map<Integer, DeliveryPerson> deliveryPersons = new HashMap<>();
    private int orderCounter = 1;

    public int placeOrder(Customer customer) {
        Order order = new Order(orderCounter, customer);
        customer.getCart().getItems().forEach(order::addItem);
        orders.put(orderCounter, order);
        System.out.println("Order placed successfully! Your order ID is: " + orderCounter);
        return orderCounter++;
    }

    public void viewOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders found.");
            return;
        }
        for (Order order : orders.values()) {
            System.out.println(order);
        }
    }

    public void addDeliveryPerson(DeliveryPerson dp) {
        deliveryPersons.put(dp.getDeliveryPersonId(), dp);
        System.out.println("Delivery person added successfully!");
    }

    public void assignDeliveryPersonToOrder(int orderId, int deliveryPersonId) {
        Order order = orders.get(orderId);
        DeliveryPerson dp = deliveryPersons.get(deliveryPersonId);
        if (order != null && dp != null) {
            order.setDeliveryPerson(dp);
            System.out.println("Delivery person assigned to order successfully!");
        } else {
            System.out.println("Order or Delivery Person not found!");
        }
    }

    public Map<Integer, Order> getOrders() {
        return orders;
    }
}
