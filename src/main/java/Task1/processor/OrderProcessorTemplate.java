package Task1.processor;

import Task1.Models.Order;
import Task1.Models.OrderStatus;
import Task1.service.PaymentMethod;

public abstract class OrderProcessorTemplate {

    public final void process(Order order, PaymentMethod paymentMethod) {

        validate(order);
        calculate(order);
        paymentMethod.pay(order.total());
        generateInvoice(order);
        finish(order);
    }

    protected abstract void validate(Order order);

    protected void calculate(Order order) {
        System.out.println("Total: " + order.total());
    }

    protected abstract void generateInvoice(Order order);

    protected void finish(Order order) {
        order.setStatus(OrderStatus.DELIVERED);
    }
}