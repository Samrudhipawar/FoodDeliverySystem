package com.tns.fooddeliverysystem.services;

//<<<<<<< HEAD
import com.tns.fooddeliverysystem.entities.FoodItem;
import com.tns.fooddeliverysystem.entities.Restaurant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//=======
//>>>>>>> 9b63b36 (initial commit)
public class FoodService {
    private Map<Integer, Restaurant> restaurants = new HashMap<>();

    public void addRestaurant(Restaurant restaurant) {
        restaurants.put(restaurant.getId(), restaurant);
        System.out.println("Restaurant added successfully!");
    }

    public void addFoodItemToRestaurant(int restaurantId, FoodItem foodItem) {
        Restaurant restaurant = restaurants.get(restaurantId);
        if (restaurant != null) {
            restaurant.addFoodItem(foodItem);
            System.out.println("Food item added successfully!");
        } else {
            System.out.println("Restaurant not found!");
        }
    }

    public void removeFoodItemFromRestaurant(int restaurantId, int foodItemId) {
        Restaurant restaurant = restaurants.get(restaurantId);
        if (restaurant != null) {
            restaurant.removeFoodItem(foodItemId);
            System.out.println("Food item removed successfully!");
        } else {
            System.out.println("Restaurant not found!");
        }
    }

    public Map<Integer, Restaurant> getAllRestaurants() {
        return restaurants;
    }

    public void viewRestaurantsAndMenus() {
        System.out.println("Restaurants and Menus:");
        for (Restaurant restaurant : restaurants.values()) {
            System.out.println("Restaurant ID: " + restaurant.getId() + ", Name: " + restaurant.getName());
            List<FoodItem> menu = restaurant.getMenu();
            if (menu.isEmpty()) {
                System.out.println("  - No food items available");
            } else {
                for (FoodItem item : menu) {
                    System.out.println("  - Food Item ID: " + item.getId() + ", Name: " + item.getName() +
                            ", Price: Rs. " + item.getPrice());
                }
            }
        }
    }

    public FoodItem findFoodItemById(int restaurantId, int foodItemId) {
        Restaurant restaurant = restaurants.get(restaurantId);
        if (restaurant != null) {
            for (FoodItem item : restaurant.getMenu()) {
                if (item.getId() == foodItemId) return item;
            }
        }
        return null;
    }
}

