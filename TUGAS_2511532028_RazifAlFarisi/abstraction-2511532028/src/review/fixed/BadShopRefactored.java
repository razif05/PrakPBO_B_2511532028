package review.fixed;


import java.util.ArrayList;
import java.util.List;

/*
 * T3 - CODE REVIEW
 * This file compiles and runs, but its design has several problems.
 * Find them, explain them, and refactor (see the module for instructions).
 */


// perbaikan GiftVoucher unsupportedOperation
interface StoreOperations {
    boolean pay(long amount);

    default boolean refund(long amount) {
        return false;
    }

    String printInvoice();
}


class GiftVoucher implements StoreOperations {
    private long balance;
    // perbaikan GiftVoucher
    public GiftVoucher(long balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Saldo awal tidak boleh negatif");
        }
        this.balance = balance;
    }

    @Override
    public boolean pay(long amount) {
        if (amount <= 0 ) {
            throw new IllegalArgumentException("Jumlah bayar harus lebih dari 0");
        }
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    @Override 
    public boolean refund(long amount) {
        if (amount > balance) {
            return false;
        }
        balance += amount;
        return true;
    }

    @Override
    public String printInvoice() {
        return "Voucher, remaining balance " + balance;
    }
}

abstract class Courier {
    public long cost(String type, int kilograms) {
        switch (type) {
            case "REGULAR":
                return kilograms * 10_000L;
            case "EXPRESS":
                return kilograms * 18_000L;
            case "SAME_DAY":
                return kilograms * 30_000L;
            default:
                return 0;
        }
    }
}

class JneCourier extends Courier {
}

class Cart {
    private final List<Item> items = new ArrayList<>();

    class Item {
        private final String name;
        private final long price;
        private final int quantity;

        Item(String name, long price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        long subtotal() {
            return price * quantity;
        }

        String getName() {
            return name;
        }
    }

    void add(Item item) {
        items.add(item);
    }

    long total() {
        long total = 0;
        for (Item item : items) {
            total += item.subtotal();
        }
        return total;
    }
}

class Address {
    private String street;
    private String city;

    Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return street + ", " + city;
    }
}

class SimpleOrder {
    private final String id;
    private final Address address;

    SimpleOrder(String id, Address address) {
        this.id = id;
        this.address = address;
    }

    Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return id + " -> " + address;
    }
}

// perbaikan discount, percentdiscount, member, dan flashsale
interface Discount {
    long apply(long price);
}
 
abstract class PercentDiscount implements Discount {
    private final int percent;
 
    protected PercentDiscount(int percent) {
        this.percent = percent;
    }
 
    @Override
    public final long apply(long price) {
        return price - price * percent / 100;
    }
}
 
class MemberDiscount extends PercentDiscount {
    MemberDiscount() {
        super(5);
    }
}
 
class FlashSaleDiscount extends PercentDiscount {
    FlashSaleDiscount() {
        super(30);
    }
}

public class BadShopRefactored {
    public static void main(String[] args) {
        Cart cart = new Cart();
        cart.add(cart.new Item("Kopi Gayo", 85_000, 2));
        System.out.println("Total cart: " + cart.total());

        Courier courier = new JneCourier();
        System.out.println("Ongkir EXPRES 2 kg: " + courier.cost("EXPRES", 2));

        Address home = new Address("Jl. Sudirman 10", "Padang");
        SimpleOrder first = new SimpleOrder("ORD-1", home);
        SimpleOrder second = new SimpleOrder("ORD-2", home);
        second.getAddress().setCity("Bukittinggi");
        System.out.println(first);
        System.out.println(second);

        Discount flashSale = new FlashSaleDiscount();
        System.out.println("Harga flash sale: " + flashSale.apply(100_000));

        StoreOperations voucher = new GiftVoucher(100000);
        System.out.println(voucher.pay(30_000) + " | " + voucher.printInvoice());
        System.out.println(voucher.refund(20000) + " | " + voucher.printInvoice());
    }
}


