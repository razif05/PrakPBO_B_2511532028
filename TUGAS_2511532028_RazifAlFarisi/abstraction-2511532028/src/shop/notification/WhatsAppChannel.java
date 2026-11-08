package shop.notification;

public class WhatsAppChannel extends AbstractChannel {

    public WhatsAppChannel() {

    }

    @Override
    public String channelName() {
        return "Whatsapp";
    }

    @Override
    protected String destination(CustomerContact contact) {
        if (contact.getPhone() == null || contact.getPhone().length() < 10) {
            return null;
        } else 
        if (contact.getPhone().startsWith("08") || contact.getPhone().startsWith("+62")) {
            return contact.getPhone();
        }
        return null;
    }

    @Override
    protected String formatMessage(CustomerContact contact, String message) {
        return "[WA to "+ destination(contact) + "] [Toko UMKM] " + message;
    }

}
