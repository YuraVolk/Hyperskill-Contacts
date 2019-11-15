package contacts;

//TODO add organization
public class Contact extends Entry {
    private String phone;
    private String surname;

    public void setPhone(String phone) {
        this.phone = phone;
        isValidNumber(phone);
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


    @Override
    void print() {
        System.out.println("");
    }
}
