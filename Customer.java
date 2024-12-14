package foodmanagement;

public class Customer {
    private String name;
    private String username;
    private String password;
    private String phoneNumber;

    public Customer(String name, String username, String password, String phoneNumber) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Customer [Name=" + name + ", Username=" + username + ", Phone Number=" + phoneNumber + "]";
    }
}
