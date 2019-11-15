package contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Contacts {
    List<Entry> contacts = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    void printContacts() {
        for (int i = 0; i < contacts.size(); i++) {
            System.out.printf("%s. ", i + 1);
            contacts.get(i).print();
        }
    }

    void start() {
        Command command;
        String choice;

        contacts:
        while (true) {
            System.out.print("Enter action (add, remove, edit, count, list, exit): ");
            choice = scanner.next();


            switch (choice) {
                case "add":
                    command = new AddContactCommand(this);
                    command.execute();
                    break;
                case "remove":
                    command = new RemoveContactCommand(this);
                    command.execute();
                    break;
                case "edit":
                    command = new EditContactCommand(this);
                    command.execute();
                    break;
                case "count":
                    System.out.printf("The phone book has %s records.\n",
                            contacts.size());
                    break;
                case "list":
                    printContacts();
                    break;
                case "exit":
                    break contacts;
            }
        }
    }
}
