package Task1.repository;

import Task1.Models.Order;
import java.util.Optional;

public class OrderService {
    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public void createOrder(Order order) {
        repository.save(order);
    }

    public Optional<Order> findOrder(long id) {
        return repository.findById(id);
    }
}