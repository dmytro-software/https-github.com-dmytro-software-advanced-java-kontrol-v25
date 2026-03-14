package Task1.service.Impl;

import Task1.service.PaymentMethod;

public class BankTransferImpl implements PaymentMethod {

    @Override
    public void pay(double amount) {

        double commission = amount * 0.01;
        double total = amount + commission;

        System.out.println("Bank transfer total: " + total);
    }
}
