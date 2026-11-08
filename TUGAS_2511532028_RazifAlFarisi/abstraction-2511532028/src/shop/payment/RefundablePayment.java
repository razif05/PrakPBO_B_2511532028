package shop.payment;

public interface RefundablePayment extends PaymentMethod{

    boolean refund(long amount);
    
    // T1.e
    default String policy() { 
        return "Refund maksimal 7 hari"; 
    } 

}
