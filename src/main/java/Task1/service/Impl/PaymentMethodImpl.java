package Task1.service.Impl;

import Task1.service.PaymentMethod;

public class PaymentMethodImpl implements PaymentMethod {

    @Override
    public void pay(double amount) {

        if (amount > 20000) {
            throw new IllegalArgumentException("Card limit exceeded");
        }

        System.out.println("Paid by card: " + amount);
    }
}
