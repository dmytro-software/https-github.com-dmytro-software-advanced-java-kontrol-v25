package Task1.service.Impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentMethodImplTest {
    PaymentMethodImpl payment = new PaymentMethodImpl();

    @Test
    void tooBigAmount() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> payment.pay(2500000.0)
        );
        assertEquals("Card limit exceeded", ex.getMessage());
    }
}