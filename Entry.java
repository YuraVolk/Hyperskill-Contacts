package contacts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Entry {
    private String name;

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    abstract void print();

    private int isCorrectParentheses(String group) {
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
            groups = phone.split("[-\\s]");
        } else {
            groups = phone.substring(1).split("[-\\s]");
        }

        int count = 0;

        int[] passed = new int[groups.length];
        for (int i = 0; i < groups.length; i++) {
            passed[i] = isCorrectParentheses(groups[i]);
            count += passed[i];
        }

        if (count > 1) {
            System.out.println("Too much parentheses.");
            return false;
        }


        for (int i = 0; i < passed.length; i++) {
            if (i > 1 && passed[i] != 0) {
                System.out.println("Parentheses where they can't be.");
                return false;
            }

            //Group can be 09(09)09, which is wrong. One More check
            if (groups[i].contains("(") && !groups[i].startsWith("(")) {
                System.out.println("Parentheses must be separated.");
                return false;
            }


            if (groups[i].startsWith("(")) {
                groups[i] = groups[i].substring(1, groups[i].length() - 1);
            }
        }

        String finalPhone = phone.replaceAll("[()]", "");

        Pattern pattern = Pattern.compile(
                "((\\+?[\\s-]?)([a-zA-z0-9]+[\\s-]?)(([a-zA-z0-9]{2,}[\\s-])*))");
        Matcher matcher = pattern.matcher(finalPhone);

        if (matcher.find()) {
            System.out.println(finalPhone.length());
            return true;
        } else {
            System.out.println("Wrong format.");
            return false;
        }
    }
}
