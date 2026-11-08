package shop.payment;

public interface PaymentMethod {

    String getName();

    /** @return true if the payment succeeds */
    boolean pay(long amount);

    /* T1.a  */
    // abstract long adminFee(long amount);
    default long adminFee(long amount) {
        return 0;
    }
}
