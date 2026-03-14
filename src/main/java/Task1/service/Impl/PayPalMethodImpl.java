package Task1.service.Impl;

import Task1.service.PaymentMethod;

public class PayPalMethodImpl implements PaymentMethod {

    @Override
    public void pay(double amount) {

        if (amount < 100) {
            throw new IllegalArgumentException("PayPal minimum is 100");
        }

        System.out.println("Paid via PayPal: " + amount);
    }
}
