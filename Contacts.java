package contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Contacts {
    public List<Entry> contacts = new ArrayList<>();
    public Scanner scanner = new Scanner(System.in);
    private Command command;

    void start() {
        command = new AddContactCommand(this);
    }
}
