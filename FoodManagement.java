package foodmanagement;

import java.util.ArrayList;
import java.util.List;

public class FoodManagement {
    private List<Customer> customers = new ArrayList<>();
    private List<FoodItem> foodItems = new ArrayList<>();
    private List<String> orderHistory = new ArrayList<>();
    private double totalRevenue = 0;

    // Register a new customer
    public void registerCustomer(String name, String username, String password, String phoneNumber) {
        if (phoneNumber.length() > 11) {
            System.out.println("Phone number cannot exceed 11 digits.");
            return;
        }
        for (Customer customer : customers) {
            if (customer.getUsername().equals(username)) {
                System.out.println("Username already exists. Please choose another.");
                return;
            }
        }
        customers.add(new Customer(name, username, password, phoneNumber));
        System.out.println("Registration successful.");
    }

    // Login a customer
    public boolean loginCustomer(String username, String password) {
        for (Customer customer : customers) {
            if (customer.getUsername().equals(username) && customer.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    // Add a new food item
    public void addFoodItem(FoodItem foodItem) {
        foodItems.add(foodItem);
        System.out.println("Food item added successfully.");
    }

    // Display all food items
    public void displayFoodItems() {
        if (foodItems.isEmpty()) {
            System.out.println("No food items available.");
        } else {
            for (FoodItem item : foodItems) {
                System.out.println(item);
            }
        }
    }

    // Search for a food item by ID
    public FoodItem searchFoodItemById(String id) {
        for (FoodItem item : foodItems) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        System.out.println("Food item not found.");
        return null;
    }

    // Update a food item
    public void updateFoodItem(String id, String name, double price) {
        FoodItem item = searchFoodItemById(id);
        if (item != null) {
            item.setName(name);
            item.setPrice(price);
            System.out.println("Food item updated successfully.");
        }
    }

    // Remove a food item
    public void removeFoodItem(String id) {
        FoodItem item = searchFoodItemById(id);
        if (item != null) {
            foodItems.remove(item);
            System.out.println("Food item removed successfully.");
        }
    }

    // Place an order
    public void placeOrder(String id, int quantity) {
        FoodItem item = searchFoodItemById(id);
        if (item != null) {
            if (item.getQuantity() >= quantity) {
                item.reduceQuantity(quantity);
                double cost = item.getPrice() * quantity;
                totalRevenue += cost;
                orderHistory.add("Ordered " + quantity + " of " + item.getName() + " for $" + cost);
                System.out.println("Order placed successfully. Cost: $" + cost);
            } else {
                System.out.println("Insufficient stock for the order.");
            }
        }
    }

    // View order history
    public void viewOrderHistory() {
        if (orderHistory.isEmpty()) {
            System.out.println("No orders have been placed.");
        } else {
            for (String order : orderHistory) {
                System.out.println(order);
            }
        }
    }

    // Calculate total revenue
    public double calculateTotalRevenue() {
        return totalRevenue;
    }
}
