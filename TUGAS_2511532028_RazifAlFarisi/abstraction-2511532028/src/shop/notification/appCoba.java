package shop.notification;

public class appCoba {
    
    public static void main(String[] args) {
        SmsChannel man = new SmsChannel(10);
        man.send(new CustomerContact("rare", "rear", "0812335345"), "Hello World! I'm here");
        System.out.println(man.getLastDelivered());
        String hy = "hello wor";
        int max = 4;
        
        System.out.println();
        if (hy.length() > max) {
            System.out.println(hy.substring(0, max));
        }

    }
    

}
