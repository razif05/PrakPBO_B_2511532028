package shop.notification;

public interface NotificationChannel {

    // T2
    String channelName();

    boolean send(CustomerContact contact, String message);

}
