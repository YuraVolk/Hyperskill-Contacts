package contacts;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Contacts implements Serializable {
    List<Entry> contacts = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    private String filename = "file.ser";

    void printContacts() {
        for (int i = 0; i < contacts.size(); i++) {
            System.out.printf("%s. ", i + 1);
            contacts.get(i).printCompact();
        }
    }

    private void serialize() {
        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(contacts);

            out.close();
            file.close();
        } catch (IOException e) {
            System.exit(-1);
        }
    }

    private void deserialize() throws Exception{

            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream out = new ObjectInputStream(file);

            this.contacts = (List<Entry>) out.readObject();
            System.out.println(this.contacts);
            out.close();
            file.close();

    }

    void start() throws Exception{
       // deserialize();
        Command command;
        String choice;

        contacts:
        while (true) {
            System.out.print("Enter action (add, remove, edit, count, info, exit): ");
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
                case "info":
                    command = new ShowInfoCommand(this);
                    command.execute();
                    break;
                case "exit":
                    break contacts;
            }
        }

//        serialize();
    }
}
