package Task1.repository;


import Task1.Models.Order;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OrderRepositoryImpl implements OrderRepository {
    private final Map<Long, Order> database = new HashMap<>();

    @Override
    public Optional<Order> findById(long id) {
        return Optional.ofNullable(database.get(id));
    }

    @Override
    public void save(Order order) {
        database.put(order.getId(), order);
        System.out.println("Репозиторій: Замовлення #" + order.getId() + " збережено.");
    }
}