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
        System.out.println("Select a field (name, surname, number):");
        String fieldChoice = contacts.scanner.next();
        System.out.printf("Enter %s:", fieldChoice);
        contacts.scanner.nextLine();
        String field = contacts.scanner.nextLine();
        record--;

        switch (fieldChoice) {
            case "name":
                contacts.contacts.get(record).setName(field);
                break;
            case "surname":
                ((Contact) contacts.contacts.get(record)).setSurname(field);
                break;
            case "number":
                contacts.contacts.get(record).setPhone(field);
                break;
        }

        System.out.println("The record updated!");
    }
}
