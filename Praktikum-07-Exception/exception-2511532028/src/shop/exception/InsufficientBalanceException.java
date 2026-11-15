package shop.exception;

public class InsufficientBalanceException extends PaymentFailedException {

    public static final long serialVersionUID = 1L;

    private long required;
    private long available;

    public InsufficientBalanceException(long required, long available) {
        if (available >= required) {
            throw new IllegalArgumentException("Saldo is sufficient, this is not an error");
        }
        super("Saldo tidak cukup: perlu Rp " + required + ", tersedia Rp " + available);
        this.required = required;
        this.available = available;
    }

    public long getRequired() { return required;}
    public long getAvailable() { return available;}
    public long getShortFall() { return required - available;}

}
