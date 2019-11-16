package contacts;

public class AddContactCommand extends Command {
    public AddContactCommand(Contacts contacts) {
        super(contacts);
    }

    @Override
    public void execute() {
        Contact contact = new Contact(contacts);
        contact.create();
        contact.print();

        System.out.println("The record added.\n");
    }
}
