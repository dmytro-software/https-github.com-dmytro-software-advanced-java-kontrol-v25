package Task1;
import Task1.Models.Order;
import Task1.Models.OrderItem;
import Task1.facade.OrderManagerFacade;
import Task1.processor.DefaultOrderProcessor;
import Task1.repository.OrderRepositoryImpl;
import Task1.repository.OrderService;
import Task1.service.Impl.BankTransferImpl;
import Task1.service.Impl.PayPalMethodImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        OrderRepositoryImpl repository = new OrderRepositoryImpl();

        OrderService orderService = new OrderService(repository);
        DefaultOrderProcessor processor = new DefaultOrderProcessor();

        OrderManagerFacade orderFacade = new OrderManagerFacade(orderService, processor);

        OrderItem item1 = new OrderItem("Laptop", 200.0);
        OrderItem item2 = new OrderItem("Mouse", 350.0);

        Order myOrder = new Order(101L, List.of(item1, item2));

        orderFacade.placeAndProcessOrder(myOrder, new BankTransferImpl());

        Order smallOrder = new Order(102L, List.of(new OrderItem("Coffee", 1220.0)));
        orderFacade.placeAndProcessOrder(smallOrder, new PayPalMethodImpl());
    }
}