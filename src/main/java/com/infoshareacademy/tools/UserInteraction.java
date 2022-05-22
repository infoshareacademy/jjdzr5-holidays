package com.infoshareacademy.tools;

import java.time.LocalDate;
import java.util.Scanner;

public class UserInteraction {

    public static String getTypeOfHoliday() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz typ święta: ");
        return scanner.nextLine();
    }

    public static LocalDate getLocalDate () {
        Scanner scanner = new Scanner(System.in);
        boolean inputIsIncorrect = true;
        LocalDate localDateFromUser = null;
        do {
            try {
                System.out.println("Podaj datę w formacie yyyy-MM-dd");
                String dateInputFromUser = scanner.next();
                localDateFromUser = LocalDate.parse(dateInputFromUser);
                inputIsIncorrect = false;
            } catch (Exception e) {
                System.out.println("Format daty jest niepoprawny.");
            }
        } while (inputIsIncorrect);

        return localDateFromUser;
    }
}
