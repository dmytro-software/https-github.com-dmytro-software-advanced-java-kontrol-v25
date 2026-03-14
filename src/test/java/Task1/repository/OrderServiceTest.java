package Task1.repository;

import Task1.Models.Order;
import Task1.Models.OrderItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    private OrderService service;
    private OrderRepositoryImpl repository;

    @BeforeEach
    void setup() {
        repository = new OrderRepositoryImpl();
        service = new OrderService(repository);
    }

    @Test
    void createOrderShouldSaveOrder() {
        Order order = new Order(1, List.of(new OrderItem("Laptop", 600)));
        service.createOrder(order);
        Optional<Order> result = repository.findById(1);
        assertTrue(result.isPresent());
    }

    @Test
    void createOrderDifferentOrders() {

        Order order1 = new Order(3, List.of(new OrderItem("Mouse", 200)));
        Order order2 = new Order(4, List.of(new OrderItem("Keyboard", 300)));
        service.createOrder(order1);
        service.createOrder(order2);
        assertTrue(repository.findById(3).isPresent());
        assertTrue(repository.findById(4).isPresent());
    }

    @Test
    void createOrder_orderTotalShouldBeCorrect() {
        Order order = new Order(5, List.of(new OrderItem("Item1", 200)));
        service.createOrder(order);
        assertEquals(200, order.total());
    }

    @Test
    void createOrder_repositoryShouldContainOrder() {

        Order order = new Order(6, List.of(new OrderItem("Tablet", 800)));
        service.createOrder(order);
        Optional<Order> result = repository.findById(6);
        assertNotNull(result);
    }
}
