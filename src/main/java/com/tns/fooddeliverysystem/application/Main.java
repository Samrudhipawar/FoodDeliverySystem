package com.tns.fooddeliverysystem.application;

<<<<<<< HEAD
=======
public class Main {
     public static void main(String[] args) {
        System.out.println("Hello, Food Delivery!");
        System.out.println("Admin");
        System.out.println("java project");
        System.out.println("Restaurant");
        System.out.println("Cart");
    }
>>>>>>> fceb6d0 (Cart commit)

import com.tns.fooddeliverysystem.entities.*;
import com.tns.fooddeliverysystem.services.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FoodService foodService = new FoodService();
        CustomerService customerService = new CustomerService();
        OrderService orderService = new OrderService();

        while (true) {
            System.out.println("\n1. Admin Menu");
            System.out.println("2. Customer Menu");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                boolean adminLoop = true;
                while (adminLoop) {
                    System.out.println("\nAdmin Menu:");
                    System.out.println("1. Add Restaurant");
                    System.out.println("2. Add Food Item to Restaurant");
                    System.out.println("3. Remove Food Item from Restaurant");
                    System.out.println("4. View Restaurants and Menus");
                    System.out.println("5. View Orders");
                    System.out.println("6. Add Delivery Person");
                    System.out.println("7. Assign Delivery Person to Order");
                    System.out.println("8. Exit");
                    System.out.print("Choose an option: ");
                    int adminChoice = sc.nextInt();

                    switch (adminChoice) {
                        case 1:
                            System.out.print("Enter Restaurant ID: ");
                            int rid = sc.nextInt();
                            System.out.print("Enter Restaurant Name: ");
                            sc.nextLine();
                            String rname = sc.nextLine();
                            foodService.addRestaurant(new Restaurant(rid, rname));
                            break;
                        case 2:
                            System.out.print("Enter Restaurant ID: ");
                            int resId = sc.nextInt();
                            System.out.print("Enter Food Item ID: ");
                            int fid = sc.nextInt();
                            System.out.print("Enter Food Item Name: ");
                            sc.nextLine();
                            String fname = sc.nextLine();
                            System.out.print("Enter Food Item Price: ");
                            double price = sc.nextDouble();
                            foodService.addFoodItemToRestaurant(resId, new FoodItem(fid, fname, price));
                            break;
                        case 3:
                            System.out.print("Enter Restaurant ID: ");
                            int rrid = sc.nextInt();
                            System.out.print("Enter Food Item ID: ");
                            int rfId = sc.nextInt();
                            foodService.removeFoodItemFromRestaurant(rrid, rfId);
                            break;
                        case 4:
                            foodService.viewRestaurantsAndMenus();
                            break;
                        case 5:
                            orderService.viewOrders();
                            break;
                        case 6:
                            System.out.print("Enter Delivery Person ID: ");
                            int dpId = sc.nextInt();
                            System.out.print("Enter Delivery Person Name: ");
                            sc.nextLine();
                            String dpName = sc.nextLine();
                            System.out.print("Enter Contact No.: ");
                            long dpContact = sc.nextLong();
                            orderService.addDeliveryPerson(new DeliveryPerson(dpId, dpName, dpContact));
                            break;
                        case 7:
                            System.out.print("Enter Order ID: ");
                            int oid = sc.nextInt();
                            System.out.print("Enter Delivery Person ID: ");
                            int dpid = sc.nextInt();
                            orderService.assignDeliveryPersonToOrder(oid, dpid);
                            break;
                        case 8:
                            adminLoop = false;
                            System.out.println("Exiting Admin Module");
                            break;
                    }
                }
            }
            else if (choice == 2) {
                boolean customerLoop = true;
                while (customerLoop) {
                    System.out.println("\nCustomer Menu:");
                    System.out.println("1. Add Customer");
                    System.out.println("2. View Food Items");
                    System.out.println("3. Add Food to Cart");
                    System.out.println("4. View Cart");
                    System.out.println("5. Place Order");
                    System.out.println("6. View Orders");
                    System.out.println("7. Exit");
                    System.out.print("Choose an option: ");
                    int customerChoice = sc.nextInt();

                    switch (customerChoice) {
                        case 1:
                            System.out.print("Enter User ID: ");
                            int uid = sc.nextInt();
                            System.out.print("Enter Username: ");
                            sc.nextLine();
                            String uname = sc.nextLine();
                            System.out.print("Enter Contact No.: ");
                            long contact = sc.nextLong();
                            customerService.addCustomer(new Customer(uid, uname, contact));
                            break;
                        case 2:
                            foodService.viewRestaurantsAndMenus();
                            break;
                        case 3:
                            System.out.print("Enter Customer ID: ");
                            int custId = sc.nextInt();
                            Customer customer = customerService.getCustomerById(custId);
                            if (customer != null) {
                                System.out.print("Enter Restaurant ID: ");
                                int resId = sc.nextInt();
                                System.out.print("Enter Food Item ID: ");
                                int foodId = sc.nextInt();
                                System.out.print("Enter Quantity: ");
                                int qty = sc.nextInt();
                                FoodItem food = foodService.findFoodItemById(resId, foodId);
                                if (food != null) {
                                    customer.getCart().addItem(food, qty);
                                    System.out.println("Food item added to cart!");
                                } else {
                                    System.out.println("Food item not found!");
                                }
                            } else {
                                System.out.println("Customer not found!");
                            }
                            break;
                        case 4:
                            System.out.print("Enter Customer ID: ");
                            int cid = sc.nextInt();
                            Customer cust = customerService.getCustomerById(cid);
                            if (cust != null) {
                                System.out.println(cust.getCart());
                            } else {
                                System.out.println("Customer not found!");
                            }
                            break;
                        case 5:
                            System.out.print("Enter Customer ID: ");
                            int ccid = sc.nextInt();
                            Customer c = customerService.getCustomerById(ccid);
                            if (c != null) {
                                orderService.placeOrder(c);
                            } else {
                                System.out.println("Customer not found!");
                            }
                            break;
                        case 6:
                            orderService.viewOrders();
                            break;
                        case 7:
                            customerLoop = false;
                            System.out.println("Exiting Customer Module");
                            break;
                    }
                }
            }
            else if (choice == 3) {
                System.out.println("Exiting Application. Goodbye!");
                break;
            }
        }
        sc.close();
    }
}
