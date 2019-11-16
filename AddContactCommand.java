package contacts;

public class AddContactCommand extends Command {
    AddContactCommand(Contacts contacts) {
        super(contacts);
    }

    @Override
    public void execute() {
        Contact contact = new Contact(contacts);
        contact.create();

        System.out.println("The record added.\n");
    }
}
