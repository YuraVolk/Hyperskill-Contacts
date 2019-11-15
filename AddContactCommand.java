package contacts;

public class AddContactCommand extends Command {
    public AddContactCommand(Contacts contacts) {
        super(contacts);
        execute();
    }

    @Override
    public void execute() {
        System.out.println("Enter the name of the person: ");
        String name = contacts.scanner.nextLine();
        System.out.println("Enter the surname of the person: ");
        String surname = contacts.scanner.nextLine();
        System.out.println("Enter the number: ");
        String number = contacts.scanner.nextLine();

        Contact contact = new Contact();
        contact.setName(name);
        contact.setSurname(surname);
        contact.setPhone(number);

        contacts.contacts.add(contact);
        System.out.println("\nA record created!\n" +
                "A Phone Book with a single record created!");
    }
}
