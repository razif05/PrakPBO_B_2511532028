package shop.notification;

public class SmsChannel extends AbstractChannel {

    private int maxLength;

    public SmsChannel(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public String channelName() {
        return "SMS";
    }

    @Override
    protected String destination(CustomerContact contact) {
        if (!contact.getPhone().startsWith("08")) {
            return null;
        }
        return contact.getPhone();
    }

    @Override
    protected  String formatMessage(CustomerContact contact, String message) {
        if (message.length() > maxLength) {
            return "[SMS to " + destination(contact) + "] " + message.substring(0, maxLength) + "..."; 
        }
        return "[SMS] " + message;
    }


}
