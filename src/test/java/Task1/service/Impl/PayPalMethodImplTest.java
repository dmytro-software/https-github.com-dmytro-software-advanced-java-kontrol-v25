package Task1.service.Impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PayPalMethodImplTest {
    PayPalMethodImpl payment = new PayPalMethodImpl();
    @Test
    void tooSmallAmount() {

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> payment.pay(50)
        );
        assertEquals("PayPal minimum is 100", ex.getMessage());
    }

    @Test
    void minimumCase() {
        payment.pay(100);
    }

    @Test
    void validAmount() {
        payment.pay(300);
        payment.pay(870);
        payment.pay(980);
    }
}