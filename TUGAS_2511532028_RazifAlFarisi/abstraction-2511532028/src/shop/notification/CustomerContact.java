package shop.notification;

public final class CustomerContact {

    private String name;
    private String email;
    private String phone;

    public CustomerContact(String name, String email, String phone) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        } else {
            this.name = name;
        }
        if (email == null) {
            this.email = "";
        } else {
            this.email = email;
        }
        if (phone == null) {
            this.phone = "";
        } else {
            this.phone = phone;
        }
    }

    public String getName() { return name;}
    public String getEmail() { return email;}
    public String getPhone() { return phone;}

}
