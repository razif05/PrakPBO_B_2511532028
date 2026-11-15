package shop.payment;

import shop.exception.PaymentFailedException;

/** Contract for every payment method. */
public interface PaymentMethod {
    String getName();

    /** @return true if the payment succeeds 
     * @throws PaymentFailedException */
    void pay(long amount) throws PaymentFailedException;
}
