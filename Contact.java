package contacts;

//TODO add organization
public class Contact extends Entry {
    private String surname;

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    void print() {
        String number = getPhone().length() == 0 ? "[no number]" : getPhone();
        System.out.printf("%s %s, %s\n", getName(),
                surname, number);
    }
}
