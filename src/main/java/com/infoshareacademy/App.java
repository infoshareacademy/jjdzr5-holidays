package com.infoshareacademy;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import com.infoshareacademy.api.DayOffData;
import com.infoshareacademy.domain.DayOff;
import com.infoshareacademy.sort.Sorted;
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
        System.out.printf("%10s*\t1. Pokaż kalendarz dni wolnych%28s*\n", etc, etc);
        System.out.printf("%10s*\t2. Posortuj listę dni wolnych %28s*\n", etc, etc);
        System.out.printf("%10s*\t3. Wyświetl dzień wolny po dacie%26s*\n", etc, etc);
        System.out.printf("%10s*\t4. Filtrowanie dni wolnych po zakresie dat%16s*\n", etc, etc);
        System.out.printf("%10s*\t5. Filtrowanie dni wolnych po typie dnia wolnego%10s*\n", etc, etc);
        System.out.printf("%10s*\t6. Szukaj dnia wolnego po nazwie%26s*\n", etc, etc);
        System.out.printf("%10s*\t0. Wyjdź %49s*", etc, etc);
        System.out.printf("\n%10s*************************************************************\n", etc);
        System.out.printf("%10s*\tWybierz opcję 0 - 6 : ", etc);
        int option = new Scanner(System.in).nextInt();
        switch (option) {
            case 1 -> calendarPrint();
            case 2 -> Sorted.sortByName();
            case 0 -> System.exit(0);
            default -> System.out.println("Zła opcja, wybierz inną.");
        }
    }

    private static void calendarPrint() throws IOException {

        ArrayList<DayOff> dayOffList = DayOffData.getDayOffList();

        ConsoleView.displayList(dayOffList);

    }


}
