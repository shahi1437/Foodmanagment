package foodmanagement;

public class FoodItem {
    private String id;
    private String name;
    private double price;
    private int quantity;

    public FoodItem(String id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void reduceQuantity(int quantity) {
        this.quantity -= quantity;
    }

    @Override
    public String toString() {
        return "FoodItem [ID=" + id + ", Name=" + name + ", Price=$" + price + ", Quantity=" + quantity + "]";
    }
}
