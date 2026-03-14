package Task1.Models;

public class OrderItem {

    private final String name;
    private final double price;

    public OrderItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
