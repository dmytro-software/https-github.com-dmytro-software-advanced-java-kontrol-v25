package Task1.processor;

import Task1.Models.Order;
import Task1.Models.OrderStatus;
import Task1.exeption.InvoiceGenerationException;
import Task1.exeption.ValidationException;

public class DefaultOrderProcessor extends OrderProcessorTemplate {

    @Override
    public void validate(Order order) {

        if (order.total() < 500) {
            throw new ValidationException("Order must be >= 500");
        }
    }
    @Override
    protected void generateInvoice(Order order) {

        if (order.total() == 0) {
            throw new InvoiceGenerationException("Invoice error");
        }

        order.setStatus(OrderStatus.INVOICE_SENT);
    }
}