package contacts;

abstract class Entry {
    private String name;
    private String phone;
    ContactValidator validator = new ContactValidator();
    Contacts contacts;

    Entry(Contacts contacts) {
        this.contacts = contacts;
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void setPhone(String phone) {
        if (!validator.validateNumber(phone)) {
            System.out.println("Wrong number format!");
            this.phone = "";
        } else {
            this.phone = phone;
        }
    }

    String getPhone() {
        return phone;
    }

    void printCompact() {
        System.out.println(name);
    }

    abstract void print();
    abstract String getFields();
    abstract void setField(String field, String value);
    abstract void create();
}
