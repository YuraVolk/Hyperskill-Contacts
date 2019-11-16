package contacts;

class EditContactCommand extends Command {
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
        System.out.print("Select a record: ");
        int record = contacts.scanner.nextInt() - 1;
        System.out.printf("Select a field (%s): ",
                        contacts.contacts.get(record).getFields());
        String field = contacts.scanner.next();
        System.out.printf("Enter %s: ", field);
        contacts.scanner.nextLine();
        String value = contacts.scanner.nextLine();
        contacts.contacts.get(record).setField(field, value);

        System.out.println("The record updated!\n");
    }
}
