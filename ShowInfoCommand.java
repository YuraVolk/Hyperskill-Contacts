package contacts;

public class ShowInfoCommand extends Command{
    ShowInfoCommand(Contacts contacts) {
        super(contacts);
    }

    @Override
    void execute() {

        System.out.print("Select a record: ");
        int record = contacts.scanner.nextInt() - 1;
        contacts.contacts.get(record).print();
        System.out.println();
    }
}
