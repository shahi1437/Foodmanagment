package foodmanagement;

// Base class for common properties
public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Manager class inheriting from Person
class Manager extends Person {
    private String managerId;

    public Manager(String name, String managerId) {
        super(name);
        this.managerId = managerId;
    }

    public String getManagerId() {
        return managerId;
    }

    public void manageFoodItems() {
        System.out.println("Managing food items...");
    }

    @Override
    public String toString() {
        return "Manager [Name=" + getName() + ", Manager ID=" + managerId + "]";
    }
}

// Customer class inheriting from Person
class Customer extends Person {
    private String username;
    private String password;
    private String phoneNumber;

    public Customer(String name, String username, String password, String phoneNumber) {
        super(name);
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer [Name=" + getName() + ", Username=" + username + ", Phone Number=" + phoneNumber + "]";
    }
}
