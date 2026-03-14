package Task1.repository;

import Task1.Models.Order;

import java.util.Optional;

public interface OrderRepository {

    Optional<Order> findById(long id);

    void save(Order order);
}
