package Task1.facade;

import Task1.Models.Order;
import Task1.processor.OrderProcessorTemplate;
import Task1.repository.OrderService;
import Task1.service.PaymentMethod;

public class OrderManagerFacade {
    private final OrderService orderService;
    private final OrderProcessorTemplate processor;

    public OrderManagerFacade(OrderService orderService, OrderProcessorTemplate processor) {
        this.orderService = orderService;
        this.processor = processor;
    }

    public void placeAndProcessOrder(Order order, PaymentMethod paymentMethod) {
        orderService.createOrder(order);
        processor.process(order, paymentMethod);
    }
}