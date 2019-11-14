package contacts;

//TODO add organization
public class Contact extends Entry {
    private String phone;
    private String surname;

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getSurname() {
        return surname;
    }

    public Contact(String name, String surname, String phone) {
        setName(name);
        this.surname = surname;
        this.phone = phone;
    }

    @Override
    void print() {
        System.out.println("");
    }
}
