package shop.notification;

public class EmailChannel extends AbstractChannel{

    public EmailChannel() {
    }

    public String channelName() {
        return "Email";
    }

    @Override 
    public String destination(CustomerContact contact) {
        if (!contact.getEmail().contains("@")) {
            return null;
        }
        return contact.getEmail();
    }

    @Override
    protected String formatMessage(CustomerContact contact, String message) {
        
        return "[Email to " + destination(contact) + "] " + message;
    }

}
