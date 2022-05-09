package com.infoshareacademy;

import java.io.Console;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

import com.infoshareacademy.api.DayOffData;
import com.infoshareacademy.domain.DayOff;
import com.infoshareacademy.filter.Filter;
import com.infoshareacademy.view.ConsoleView;


@SuppressWarnings("ALL")
public class App {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    private String startDate;
    private String endDate;
    String etc = "";

    public static void main(String[] args) throws IOException, ParseException {
        // write your code here
        new App().window();
    }

    public void window() throws IOException, ParseException {
        System.out.printf("\n%10s*************************************************************\n", etc);
        System.out.printf("%10s*\t                   Witaj w Holidays App%19s*", etc, etc);
        System.out.printf("\n%10s*************************************************************\n", etc);
        System.out.printf("%10s*---------------------!!  MENU GŁÓWNE  !!-------------------*\n", etc);
        System.out.printf("%10s**********************    PRACODAWCA   **********************\n", etc);
        System.out.printf("%10s*\t1. Pokaż kalendarz dni wolnych%28s*\n", etc, etc);
        System.out.printf("%10s*\t2. Posortuj listę dni wolnych %28s*\n", etc, etc);
        System.out.printf("%10s*\t3. Wyświetl dzień wolny po dacie%26s*\n", etc, etc);
        System.out.printf("%10s*\t4. Filtrowanie dni wolnych po zakresie dat%16s*\n", etc, etc);
        System.out.printf("%10s*\t5. Filtrowanie dni wolnych po typie dnia wolnego%10s*\n", etc, etc);
        System.out.printf("%10s*\t0. Wyjdź %49s*", etc, etc);
        System.out.printf("\n%10s*************************************************************\n", etc);
        System.out.printf("%10s*\tWybierz opcję 0 - 5 : ", etc);
        int option = new Scanner(System.in).nextInt();
        switch (option) {
            // case 1 -> printElement();
            case 1 -> calendarPrint();
            case 4 -> ConsoleView.displayList(Filter.filterHolidayByDates());
            case 5 -> ConsoleView.displayList(Filter.filterHolidayByType());
            case 0 -> System.exit(0);
            default -> System.out.println("Zła opcja, wybierz inną.");
        }
    }

    private static void calendarPrint() throws IOException {

        ArrayList<DayOff> dayOffList = DayOffData.getDyOffList();

        ConsoleView.displayList(dayOffList);

        /*for (int i = 0; i < holidayData.size(); i++) {
            System.out.printf("%10s", "");
            System.out.println(dayOffList.get(i).getName());
            System.out.println(dayOffList.get(i).getDescription());
            System.out.println(dayOffList.get(i).getDate());
            System.out.println(dayOffList.get(i).getCountry());
            System.out.println(dayOffList.get(i).getLocations());
            System.out.println(dayOffList.get(i).getDateFrom());
            System.out.println(dayOffList.get(i).getType());
            System.out.println("");
        }*/
    }

    private void loginOwner() throws IOException, ParseException {
        int owner;
        String name;
        ArrayList<String> list = new ArrayList<>();
        do {
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
            System.out.printf("%10s*\t0. Wyloguj się %35s*\n", etc, etc);
            System.out.printf("%10s*****************************************************\n", etc);
            System.out.printf("%10s*\tWybierz opcję 0 - 6 : ", etc);
            owner = new Scanner(System.in).nextInt();
            switch (owner) {
                case 1 -> calendarPrint();
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
                    switch (x) {
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
                case 0 -> window();
            }
        } while (owner != 7);
    }

}
