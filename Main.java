package foodmanagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FoodManagement foodManagement = new FoodManagement();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        boolean loggedIn = false;

        while (running) {
            if (!loggedIn) {
                System.out.println("\nFood Management System");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        scanner.nextLine(); // Clear buffer
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Username: ");
                        String username = scanner.nextLine();
                        System.out.print("Enter Password: ");
                        String password = scanner.nextLine();
                        System.out.print("Enter Phone Number (max 11 digits): ");
                        String phoneNumber = scanner.nextLine();
                        foodManagement.registerCustomer(name, username, password, phoneNumber);
                        break;

                    case 2:
                        scanner.nextLine(); // Clear buffer
                        System.out.print("Enter Username: ");
                        String loginUsername = scanner.nextLine();
                        System.out.print("Enter Password: ");
                        String loginPassword = scanner.nextLine();
                        if (foodManagement.loginCustomer(loginUsername, loginPassword)) {
                            System.out.println("Login successful!");
                            loggedIn = true;
                        } else {
                            System.out.println("Invalid username or password.");
                        }
                        break;

                    case 3:
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }
            } else {
                System.out.println("\nFood Management System");
                System.out.println("1. Add Food Item");
                System.out.println("2. Display Food Items");
                System.out.println("3. Search Food Item");
                System.out.println("4. Update Food Item");
                System.out.println("5. Remove Food Item");
                System.out.println("6. Place an Order");
                System.out.println("7. View Order History");
                System.out.println("8. Calculate Total Revenue");
                System.out.println("9. Logout");
                System.out.println("10. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Food ID: ");
                        String foodId = scanner.next();
                        System.out.print("Enter Food Name: ");
                        scanner.nextLine();
                        String foodName = scanner.nextLine();
                        System.out.print("Enter Price: ");
                        double price = scanner.nextDouble();
                        System.out.print("Enter Quantity: ");
                        int quantity = scanner.nextInt();
                        foodManagement.addFoodItem(new FoodItem(foodId, foodName, price, quantity));
                        break;

                    case 2:
                        foodManagement.displayFoodItems();
                        break;

                    case 3:
                        System.out.print("Enter Food ID to search: ");
                        foodId = scanner.next();
                        FoodItem item = foodManagement.searchFoodItemById(foodId);
                        if (item != null) {
                            System.out.println(item);
                        }
                        break;

                    case 4:
                        System.out.print("Enter Food ID to update: ");
                        foodId = scanner.next();
                        System.out.print("Enter New Name: ");
                        scanner.nextLine();
                        String newName = scanner.nextLine();
                        System.out.print("Enter New Price: ");
                        double newPrice = scanner.nextDouble();
                        foodManagement.updateFoodItem(foodId, newName, newPrice);
                        break;

                    case 5:
                        System.out.print("Enter Food ID to remove: ");
                        foodId = scanner.next();
                        foodManagement.removeFoodItem(foodId);
                        break;

                    case 6:
                        System.out.print("Enter Food ID to order: ");
                        foodId = scanner.next();
                        System.out.print("Enter Quantity: ");
                        quantity = scanner.nextInt();
                        foodManagement.placeOrder(foodId, quantity);
                        break;

                    case 7:
                        foodManagement.viewOrderHistory();
                        break;

                    case 8:
                        System.out.println("Total Revenue: $" + foodManagement.calculateTotalRevenue());
                        break;

                    case 9:
                        loggedIn = false;
                        System.out.println("You have been logged out.");
                        break;

                    case 10:
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }
            }
        }

        scanner.close();
    }
}
