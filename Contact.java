package contacts;

import java.time.LocalDate;
import java.time.LocalDateTime;

class Contact extends Entry {
    private String surname;
    private String gender = "";
    private LocalDateTime timeCreated;
    private LocalDateTime timeEdited;
    private LocalDate birthDate;

    Contact(Contacts contacts) {
        super(contacts);
    }

    @Override
    void print() {
        String number = getPhone().length() == 0 ? "[no number]" : getPhone();
        String genderData = gender.length() == 0 ? "[no data]" : gender;
        String birth = birthDate == null ?
                "[no data]" : birthDate.toString();


        System.out.printf("Name: %s\n" +
                "Surname: %s\n" +
                "Birth date: %s\n" +
                "Gender: %s\n" +
                "Number: %s\n" +
                "Time created: %s\n" +
                "Time last edit: %s\n",
                getName(), surname, birth, genderData,
                number, timeCreated, timeEdited);
    }

    @Override
    String getFields() {
        return "name, surname, birth, gender, number";
    }

    @Override
    void setField(String field, String value) {
        switch (field) {
            case "name":
                setName(value);
                break;
            case "surname":
                surname = value;
                break;
            case "number":
                setPhone(value);
                break;
            case "gender":
                if (validator.validateGender(value)) {
                    gender = value;
                } else {
                    System.out.println("Bad gender!");
                }
                break;
            case "birth date":
                if (validator.validateBirthDate(value)) {
                    this.birthDate = LocalDate.parse(value);
                } else {
                    System.out.println("Bad birth date!");
                }
        }

        timeEdited = LocalDateTime.now();
    }

    @Override
    void create() {
        System.out.print("Enter the name: ");
        setName(contacts.scanner.next());
        System.out.print("Enter the surname: ");
        this.surname = contacts.scanner.next();
        System.out.print("Enter the birth date: ");
        contacts.scanner.nextLine();
        String date = contacts.scanner.nextLine();

        if (validator.validateBirthDate(date)) {
            this.birthDate = LocalDate.parse(date);
        } else {
            System.out.println("Bad birth date!");
        }

        System.out.print("Enter the gender (M, F): ");
        String gender = contacts.scanner.nextLine();
        if (validator.validateGender(gender)) {
            this.gender = gender;
        } else {
            System.out.println("Bad gender!");
        }

        System.out.print("Enter the number: ");
        setPhone(contacts.scanner.nextLine());

        timeCreated = LocalDateTime.now();
        timeEdited = LocalDateTime.now();

        contacts.contacts.add(this);
    }

    @Override
    void printCompact() {
        System.out.printf("%s %s\n", getName(), surname);
    }
}
