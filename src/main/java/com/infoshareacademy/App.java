package com.infoshareacademy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;


@SuppressWarnings("ALL")
public class App {
    public static void main(String[] args) throws IOException {
        // write your code here
        displayMenu();
    }

    public static void displayMenu() throws IOException {
        String etc = "";
        System.out.printf("\n\n%10s*****************************************************\n", etc);
        System.out.printf("%10s*\t               Witaj w Holidays App%15s*", etc, etc);
        System.out.printf("\n%10s*****************************************************\n", etc);
        System.out.printf("%10s*-----------------!!  MENU GŁÓWNE  !!---------------*\n", etc);
        System.out.printf("%10s*****************     LOGOWANIE    ******************\n", etc);
        System.out.printf("%10s*\t1. Zaloguj się jako Pracownik%21s*\n", etc, etc);
        System.out.printf("%10s*\t2. Zalogij się jako Pracodawca / Admin%12s*\n", etc, etc);
        System.out.printf("%10s*\t3. Wyjście %39s*\n", etc, etc);
        System.out.printf("%10s*****************************************************\n", etc);
        System.out.printf("%10s*\tWybierz opcję 1 lub 2, 3 to Wyjście : ",etc);
        int option = new Scanner(System.in).nextInt();
        switch (option) {
            case 1 -> loginEmployee();
            case 2 -> loginOwner();
            case 3 -> System.exit(0);
            default -> System.out.println("Zła opcja, wybierz inną.");
        }
    }
    private static void loginEmployee() throws IOException {
        int employee;
        ArrayList<String> list = new ArrayList<>();
        do {
            String etc = "";
            System.out.printf("\n\n%10s*****************************************************\n", etc);
            System.out.printf("%10s*\t               Witaj w Holidays App%15s*", etc, etc);
            System.out.printf("\n%10s*****************************************************\n", etc);
            System.out.printf("%10s*-----------------!!  MENU GŁÓWNE  !!---------------*\n", etc);
            System.out.printf("%10s*****************     PRACOWNIK    ******************\n", etc);
            System.out.printf("%10s*\t1. Pokaż kalendarz dni wolnych%20s*\n", etc, etc);
            System.out.printf("%10s*\t2. Złóź wniosek urlopowy %25s*\n", etc, etc);
            System.out.printf("%10s*\t3. Znajdz Pracownika %29s*\n", etc, etc);
            System.out.printf("%10s*\t4. Pokaż wszystkich pracowników%19s*\n", etc, etc);
            System.out.printf("%10s*\t5. Wyloguj się %35s*\n", etc, etc);
            System.out.printf("%10s*****************************************************\n", etc);
            System.out.printf("%10s*\tWybierz opcję 1 - 5 : ", etc);
            employee = new Scanner(System.in).nextInt();
            switch(employee) {
                case 1 -> calendarPrint();
                case 2 -> holidays();
                case 3 -> {
                    int e = 0;
                    System.out.printf("%10s*\tWpisz nazwisko Pracownika, którego chcesz znaleźć\n", " ");
                    System.out.printf("%10s* ", "");
                    String searchName = new Scanner(System.in).nextLine();
                    for (String s : list) {
                        if (searchName.equals(s)) {
                            e = 1;
                            break;
                        }
                    }
                    System.out.printf("%10s* ", "");
                    switch(e) {
                        case 1 -> System.out.print("W bazie danych mamy dopasowanie dla " + searchName);
                        default -> System.out.print("Brak dopasowania do " + searchName);
                    }
                    loginEmployee();
                }
                case 4 -> {
                    System.out.printf("%10s* ", "");
                    System.out.println("Lista Pracowników:");
                    for (String s : list) {
                        System.out.printf("%10s* ", "");
                        System.out.println(s);
                    }
                }
                case 5 -> displayMenu();
            }
        } while (employee != 5);

    }
    public static void holidays() {
        Scanner scn = new Scanner(System.in);

        System.out.println("Podaj pierwszą datę : ");

        System.out.print("Dzień : ");
        int dayOne = scn.nextInt();

        System.out.print("Miesiąc : ");
        int monthOne = scn.nextInt();

        System.out.print("Rok  : ");
        int yearOne = scn.nextInt();

        Calendar calendar = Calendar.getInstance();
        calendar.set(yearOne,monthOne - 1,dayOne);

        System.out.println();
        System.out.println("Podaj końcowa datę : ");

        System.out.print("Dzień : ");
        int dayNext = scn.nextInt();

        System.out.print("Miesiąc : ");
        int monthNext = scn.nextInt();

        System.out.print("Rok : ");
        int yearNext = scn.nextInt();

        Calendar calendarNext = Calendar.getInstance();
        calendarNext.set(yearNext,monthNext - 1,dayNext);

        long timeInMillis = calendar.getTimeInMillis();
        long timeInMillisTwo = calendarNext.getTimeInMillis();

        long day = timeInMillisTwo - timeInMillis;

        long days = day / (24 * 60 * 60 * 1000);

        System.out.println();
        System.out.println("Wybrałeś : " + days + " days");

        long m_r = (26 - days);
        System.out.println("Zostało : " + m_r + " day(s)");
    }
    private static void calendarPrint() throws IOException {
        try {
            byte[] mapData = Files.readAllBytes(Paths.get("data.json"));
            ObjectMapper objectMapper = new ObjectMapper();
            Holiday[] holidayArr = objectMapper.readValue(mapData, Holiday[].class);
            List<Holiday> holidayList = Arrays.asList(holidayArr);
            for (int i = 0; i < holidayList.size() ; i++) {
                System.out.printf("%10s", "");
                System.out.println(holidayList.get(i));
            }

        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void loginOwner() throws IOException {
        int owner;
        String name;
        ArrayList<String> list = new ArrayList<>();
        do {
            String etc = "";
            System.out.printf("\n%10s*****************************************************\n", etc);
            System.out.printf("%10s*\t               Witaj w Holidays App%15s*", etc, etc);
            System.out.printf("\n%10s*****************************************************\n", etc);
            System.out.printf("%10s*-----------------!!  MENU GŁÓWNE  !!---------------*\n", etc);
            System.out.printf("%10s******************    PRACODAWCA   ******************\n", etc);
            System.out.printf("%10s*\t1. Pokaż kalendarz dni wolnych%20s*\n", etc, etc);
            System.out.printf("%10s*\t2. Zarezerwuj urlop %30s*\n", etc, etc);
            System.out.printf("%10s*\t3. Akceptuj wnioski urlopowe %21s*\n", etc, etc);
            System.out.printf("%10s*\t4. Znajdź Pracownika %29s*\n", etc, etc);
            System.out.printf("%10s*\t5. Dodaj Pracownika %30s*\n", etc, etc);
            System.out.printf("%10s*\t6. Pokaż wszystkich pracowników%19s*\n", etc, etc);
            System.out.printf("%10s*\t7. Wyloguj się %35s*\n", etc, etc);
            System.out.printf("%10s*****************************************************\n", etc);
            System.out.printf("%10s*\tWybierz opcję 1 - 7 : ", etc);
            owner = new Scanner(System.in).nextInt();
            switch(owner) {
                case 1 -> calendarPrint();
                case 2 -> holidays();
                case 3 -> System.out.println("Holidays Accept"); // TODO // Fixed
                case 4 -> {
                    int x = 0;
                    System.out.printf("%10s*\tWpisz nazwisko Pracownika, którego chcesz znaleźć\n", " ");
                    System.out.printf("%10s* ", "");
                    String searchName = new Scanner(System.in).nextLine();
                    for (String s : list) {
                        if (searchName.equals(s)) {
                            x = 1;
                            break;
                        }
                    }
                    System.out.printf("%10s* ", "");
                    switch(x) {
                        case 1 -> System.out.print("W bazie danych mamy dopasowanie dla " + searchName);
                        default -> System.out.print("Brak dopasowania dla : " + searchName);
                    }
                    loginOwner();
                }
                case 5 -> {
                    System.out.printf("\n%10s*****************************************************\n", etc);
                    System.out.printf("%10s*\t               DODAWANIE PRACOWNIKA%14s *", etc, etc);
                    System.out.printf("\n%10s*****************************************************\n", etc);
                    System.out.printf("%10s* ", "");
                    System.out.print("Ilu pracowników chcesz dodać : ");
                    int number = new Scanner(System.in).nextInt();
                    int a = 0;
                    while (a < number) {
                        System.out.printf("%10s*\t", "");
                        System.out.print("Wpisz imię i nazwisko pracownika " + (a + 1) + " : ");
                        name = new Scanner(System.in).nextLine();
                        list.add(name);
                        a++;
                    }
                    for (int i = 0; i < list.size(); i++) {
                        if (i == (list.size() - 1)) {
                            System.out.printf("%10s* ", "");
                            System.out.println("Dodano " + (i + 1) + " pracowników");
                        }
                    }
                }
                case 6 -> {
                    System.out.printf("%10s* ", "");
                    System.out.println("Lista Pracowników:");
                    for (String s : list) {
                        System.out.printf("%10s* ", "");
                        System.out.println(s);
                    }
                }
                case 7 -> displayMenu();
            }
        } while (owner != 7);
    }
}
