package contacts;

public abstract class Entry {
    private String name;

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    abstract void print();
}
