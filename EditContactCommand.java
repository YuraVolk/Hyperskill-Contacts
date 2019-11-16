package contacts;

public class EditContactCommand extends Command {
    EditContactCommand(Contacts contacts) {
        super(contacts);
    }

    @Override
    void execute() {
        if (contacts.contacts.size() == 0) {
            System.out.println("No records to edit!");
            return;
        }

        contacts.printContacts();
        System.out.println("Select a record: ");
        int record = contacts.scanner.nextInt();

        System.out.println("The record updated!");
    }
}
