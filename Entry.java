package contacts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Entry {
    private String name;
    private String phone;

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void setPhone(String phone) {
        if (!isValidNumber(phone)) {
            System.out.println("Wrong number format!");
            this.phone = "";
        } else {
            this.phone = phone;
        }
    }

    public String getPhone() {
        return phone;
    }

    abstract void print();


    //Correct number check

    private int isCorrectParentheses(String group) {
        if (group.matches("\\(\\)+")) {
            return Integer.MIN_VALUE;
        }

        if (group.startsWith("(")) {
            if (group.endsWith(")")) {
                return 1;
            }

            return Integer.MIN_VALUE;
        } else if (group.endsWith(")")) {
            return Integer.MIN_VALUE;
        }
        return 0;
    }

    boolean isValidNumber(String phone) {
        String[] groups;

        if (phone.startsWith("+")) {
            groups = phone.substring(1).split("[-\\s]");
        } else {
            groups = phone.split("[-\\s]");
        }
        int count = 0;

        int[] passed = new int[groups.length];
        for (int i = 0; i < groups.length; i++) {
            passed[i] = isCorrectParentheses(groups[i]);
            count += passed[i];
        }

        if (count > 1) {
            return false;
        }

        if (groups[0].startsWith("+")) {
            groups[0] = groups[0].substring(1);
        }

        for (int i = 0; i < passed.length; i++) {
            System.out.println(groups[i]);
            if ((i > 1 && passed[i] != 0) ||
                    (groups[i].contains("(")
                            && !groups[i].startsWith("(")) ||
                    groups[i].contains("+") ||
                    (i > 0 && groups[i].length() == 1) ||
                    isCorrectParentheses(groups[i]) < 0) {
                return false;
            }

            if (groups[i].startsWith("(")) {
                groups[i] = groups[i].substring(1, groups[i].length() - 1);
            }
        }

        String finalPhone = phone.replaceAll("[()]", "");

        Pattern pattern = Pattern.compile(
                "(((\\+?[\\s-]?)([a-zA-z0-9]+[\\s-]?)(([a-zA-z0-9]{2,}[\\s-]))*))+");
        Matcher matcher = pattern.matcher(finalPhone);

        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

}
