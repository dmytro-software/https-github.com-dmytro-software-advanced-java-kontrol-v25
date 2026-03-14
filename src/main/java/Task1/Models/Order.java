package Task1.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {

    private final long id;
    private final List<OrderItem> items;
    private OrderStatus status;

    public Order(long id, List<OrderItem> items) {
        this.id = id;
        this.items = new ArrayList<>(items); // defensive copy
        this.status = OrderStatus.NEW;
    }

    public long getId() {
        return id;
    }

    public List<OrderItem> getItems() {
        return new ArrayList<>(items); // defensive copy
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public double total() {

        double sum = 0;

        for (OrderItem item : items) {
            sum += item.getPrice();
        }

        return sum;
    }

    @Override
    public String toString() {
        return "Order{id=" + id + ", status=" + status + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return id == order.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}