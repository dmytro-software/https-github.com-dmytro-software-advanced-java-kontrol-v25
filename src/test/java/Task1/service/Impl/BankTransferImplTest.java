package Task1.service.Impl;

import org.junit.jupiter.api.Test;


class BankTransferImplTest {

    BankTransferImpl payment = new BankTransferImpl();

    @Test
    void seccessfullAmount() {
        payment.pay(500.0);
        payment.pay(1000.0);
    }

}