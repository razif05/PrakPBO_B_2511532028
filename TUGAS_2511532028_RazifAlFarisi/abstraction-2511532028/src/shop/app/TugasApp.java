package shop.app;

import java.util.List;

import shop.StudentInfo;
import shop.model.Address;
import shop.model.DigitalProduct;
import shop.model.Order;

import shop.model.PhysicalProduct;
import shop.model.Product;
import shop.notification.CustomerContact;
import shop.notification.EmailChannel;
import shop.notification.NotificationChannel;
import shop.notification.NotificationService;
import shop.notification.SmsChannel;
import shop.notification.WhatsAppChannel;
import shop.service.CheckoutService;
import shop.shipping.ExpressShipping;

import shop.shipping.ShippingService;
import shop.payment.EWalletPayment;
import shop.payment.BankTransferPayment;
import shop.payment.CreditCardPayment;
import shop.payment.PaymentMethod;

public class TugasApp {

    public static void main(String[] args) {

        Product coffee = new PhysicalProduct("KOPI-001", "Kopi Arabika Gayo 250g", 85_000, 300);

        Product rendang = new PhysicalProduct("RDG-002", "Rendang Kemasan 250g", 120_000, 400);

        Product ebook = new DigitalProduct("EBK-003", "E-book Resep Kue Nusantara", 50_000,
                "https://toko-umkm.example/unduh/ebk-003");
        
        List<Product> cart = List.of(coffee, rendang, ebook);

        // L2 => interface and program to an interface
        CheckoutService checkout = new CheckoutService();
        // ShippingService regular = new RegularShipping();
        ShippingService express = new ExpressShipping();

        CreditCardPayment card = new CreditCardPayment("Siti Rahma", 1_000_000);
        EWalletPayment wallet = new EWalletPayment("DompetKu : ", 300_000);
        PaymentMethod transfer = new BankTransferPayment("Bank Nagari");

        long totalExpress = checkout.total(cart, express);
        long totalBank = checkout.grandTotal(cart, express, transfer);
        long totalKredit = checkout.grandTotal(cart, express, card);

        Address address = new Address("Jl. Moh Hatta No. 10", "Padang", "25121");
        Order order = new Order("ORD-0001", address);

        System.out.println("Tugas oleh Razif Al Farisi (2511532028)\n");

        System.out.println("=== T1: Total dengan biaya admin(Ekspress)");
        System.out.println("E-Wallet Dompetku   : Rp" + totalExpress);
        System.out.println("Total Bank          : Rp" + totalBank);
        System.out.println("Total Kredit        : Rp" + totalKredit);

        System.out.println("Kebijakan Kartu Kredit  : " + card.policy());
        System.out.println("Kebijakan e-wallet      : " + wallet.policy());


        EmailChannel email = new EmailChannel();
        WhatsAppChannel whatsapp = new WhatsAppChannel();
        SmsChannel sms = new SmsChannel(StudentInfo.SMS_MAX_LENGTH);

        NotificationService daftarchannel = new NotificationService();
        CustomerContact budi = new CustomerContact("Budi01", " ", "+621464123252");
        CustomerContact siti = new CustomerContact("Siti Rahma", "SitiRahma@mail.co", "081464123252");
        String pesan = "Pesanan " + order.getOrderId()
                + " sudah dikirim dengan kurir Ekspres. Nomor resi akan muncul di aplikasi dalam 1x24 jam. Terima kasih telah berbelanja produk UMKM Sumatera Barat di toko kami!";


        daftarchannel.register(email);
        daftarchannel.register(sms);
        daftarchannel.register(whatsapp);
        daftarchannel.register(new NotificationChannel() {
            @Override
            public String channelName() {
                return "LOG System";
            }

            @Override
            public boolean send(CustomerContact contact, String message) {
                System.out.println("[LOG] " + contact.getName() + " : " + message);
                return true;
            }
        });

        System.out.println("\n==T2: Notifikasi Status Pesanan==");
        // customer siti
        System.out.println("====Pesan ke Siti====");
        System.out.println("Terkirim ke Siti lewat " + daftarchannel.broadcast(siti, pesan) + " Channel");

        // customer budi
        System.out.println("\n====Pesan Ke Budi01====");
        System.out.println("Terkirim ke Budi lewat " + daftarchannel.broadcast(budi, pesan) + " Channel");
    }

}
