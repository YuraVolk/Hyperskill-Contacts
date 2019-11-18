package contacts;

public class ListCommand extends MultipleChoiceCommand {
    ListCommand(Contacts contacts) {
        super(contacts);
    }

    @Override
    void printList() {
        for (int i = 0; i < contacts.contacts.size(); i++) {
            System.out.printf("%s. ", i + 1);
            contacts.contacts.get(i).printCompact();
        }
        System.out.println();
    }

    @Override
    void execute() {
        printList();
        System.out.println("[list] Enter action ([number], back): ");
        int record = contacts.scanner.nextInt() - 1;
        contacts.contacts.get(record).print();
        System.out.println();

        String choice;
        while (true) {
            System.out.println("[record] Enter action (edit, delete, menu): ");
            choice = contacts.scanner.next();
            switch (choice) {
                case "edit":
                    editContact(record);
                    break;
                case "delete":
                    removeContact(record);
                    break;
                case "menu":
                    return;
            }
        }
    }
}
