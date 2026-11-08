package shop.notification;

public abstract class AbstractChannel implements NotificationChannel {

    // T2

    private int sentCount = 0;
    private String lastDelivered = null;

    public int getSentCount() { return sentCount; }
    public String getLastDelivered() { return lastDelivered; }

    @Override 
    public final boolean send(CustomerContact contact, String message) {
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("Message cannot be null or empty!");
        }
        
        String destination = destination(contact);

        if (destination == null) {
           return false;
        } else  {

        String formattedMessage = formatMessage(contact, message);

        System.out.println(formattedMessage);

        sentCount++;
        lastDelivered = formattedMessage;

        return true;
        }
    }

    protected abstract String destination(CustomerContact contact);
    protected abstract String formatMessage(CustomerContact contact, String message);
 
}
