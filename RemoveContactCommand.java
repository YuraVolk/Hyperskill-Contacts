package contacts;

public class RemoveContactCommand extends Command {
    RemoveContactCommand(Contacts contacts) {
        super(contacts);
    }

    @Override
    void execute() {
        if (contacts.contacts.size() == 0) {
            System.out.println("No records to remove!");
            return;
        }

        contacts.printContacts();
        System.out.println("Select a record: ");
        int record = contacts.scanner.nextInt();
        contacts.contacts.remove(record - 1);
        System.out.println("Record removed!");
    }
}
