package contacts;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Contact extends Entry {
    private String surname;
    private String gender = "";
    private LocalDateTime timeCreated;
    private LocalDateTime timeEdited;
    private LocalDate birthDate;

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
                "Time last edit: %s",
                getName(), surname, birth, genderData,
                number, timeCreated, timeEdited);
    }

    @Override
    String[] getFields() {
        return new String[]{
                "name",
                "surname",
                "number",
                "gender",
                "birth date"
        };
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
                gender = value;
                break;
            case "birth date":
                try {
                    birthDate = LocalDate.parse(value);
                } catch (Exception e) {
                    System.out.println("Bad birth date!");
                    return;
                }
        }

        timeCreated = LocalDateTime.now();
        timeEdited = LocalDateTime.now();
    }
}
