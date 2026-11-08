package shop.notification;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {

    private List<NotificationChannel> daftarChannel = new ArrayList<>();

    public void register(NotificationChannel channel) {
        daftarChannel.add(channel);
    } 

    public int broadcast(CustomerContact contact, String message) {
        
        int totalSend = 0;

        for (NotificationChannel channel : daftarChannel) {

            if (channel.send(contact, message)) {

                totalSend++;
            }
        }
        return totalSend;
    }

}
