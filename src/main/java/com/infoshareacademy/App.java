package com.infoshareacademy;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;


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
        System.out.printf("\n\n%10s*****************************************************\n", etc);
        System.out.printf("%10s*\t               Holidays v0.1.2022%16s *", etc, etc);
        System.out.printf("\n%10s*****************************************************\n", etc);
        System.out.printf("%10s*\t1. Wejdź do aplikacji %28s*\n", etc, etc);
        System.out.printf("%10s*\t0. Wyjście z aplikacji %27s*\n", etc, etc);
        System.out.printf("%10s*****************************************************\n", etc);
        System.out.printf("%10s*\tWybierz opcję 1 lub 0 : ",etc);
        int option = new Scanner(System.in).nextInt();
        switch (option) {
            case 1 -> displayMenu();
            case 0 -> System.exit(0);
            default -> System.out.println("Zła opcja, wybierz inną.");
        }
    }

    public void displayMenu() throws IOException, ParseException {
        System.out.printf("\n\n%10s*****************************************************\n", etc);
        System.out.printf("%10s*\t               Witaj w Holidays App%15s*", etc, etc);
        System.out.printf("\n%10s*****************************************************\n", etc);
        System.out.printf("%10s*-----------------!!  MENU GŁÓWNE  !!---------------*\n", etc);
        System.out.printf("%10s*****************     LOGOWANIE    ******************\n", etc);
        System.out.printf("%10s*\t1. Zaloguj się jako Pracownik%21s*\n", etc, etc);
        System.out.printf("%10s*\t2. Zalogij się jako Pracodawca / Admin%12s*\n", etc, etc);
        System.out.printf("%10s*\t0. Powrót %40s*\n", etc, etc);
        System.out.printf("%10s*****************************************************\n", etc);
        System.out.printf("%10s*\tWybierz opcję 0 - 2 : ",etc);
        int option = new Scanner(System.in).nextInt();
        switch (option) {
            case 1 -> loginEmployee();
            case 2 -> loginOwner();
            case 0 -> window();
            default -> System.out.println("Zła opcja, wybierz inną.");
        }
    }

    private void loginEmployee() throws IOException, ParseException {
        int employee;
        ArrayList<String> list = new ArrayList<>();
        do {
            System.out.printf("\n\n%10s*****************************************************\n", etc);
            System.out.printf("%10s*\t               Witaj w Holidays App%15s*", etc, etc);
            System.out.printf("\n%10s*****************************************************\n", etc);
            System.out.printf("%10s*-----------------!!  MENU GŁÓWNE  !!---------------*\n", etc);
            System.out.printf("%10s*****************     PRACOWNIK    ******************\n", etc);
            System.out.printf("%10s*\t1. Pokaż kalendarz dni wolnych%20s*\n", etc, etc);
            System.out.printf("%10s*\t2. Złóź wniosek urlopowy %25s*\n", etc, etc);
            System.out.printf("%10s*\t3. Znajdz Pracownika %29s*\n", etc, etc);
            System.out.printf("%10s*\t4. Pokaż wszystkich pracowników%19s*\n", etc, etc);
            System.out.printf("%10s*\t0. Wyloguj się %35s*\n", etc, etc);
            System.out.printf("%10s*****************************************************\n", etc);
            System.out.printf("%10s*\tWybierz opcję 0 - 4 : ", etc);
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
                case 0 -> displayMenu();
            }
        } while (employee != 5);

    }
    
    public void holidays() throws ParseException, IOException {
        System.out.printf("\n%10s*****************************************************\n", etc);
        System.out.printf("%10s*\t                WNIOSEK O URLOP %17s *", etc, etc);
        System.out.printf("\n%10s*****************************************************\n", etc);
        Scanner scn = new Scanner(System.in);
        System.out.printf("%10s* ", "");
        System.out.print("Podaj imię : ");
        String name = scn.nextLine();
        System.out.printf("%10s* ", "");
        System.out.print("Podaj nazwisko : ");
        String surname = scn.nextLine();
        ArrayList<String> departmentList = new ArrayList<>();
        departmentList.add(RED_BOLD + "\t1. " + Department.DEPARTMENT_1.getName() + ANSI_RESET);
        departmentList.add(RED_BOLD + "\t2. " + Department.DEPARTMENT_2.getName() + ANSI_RESET);
        departmentList.add(RED_BOLD + "\t3. " + Department.DEPARTMENT_3.getName() + ANSI_RESET);
        departmentList.add(RED_BOLD + "\t4. " + Department.DEPARTMENT_4.getName() + ANSI_RESET);
        departmentList.add(RED_BOLD + "\t5. " + Department.DEPARTMENT_5.getName() + ANSI_RESET);
        departmentList.add(RED_BOLD + "\t6. " + Department.DEPARTMENT_6.getName() + ANSI_RESET);
        departmentList.add(RED_BOLD + "\t7. " + Department.DEPARTMENT_7.getName() + ANSI_RESET);
        departmentList.add(RED_BOLD + "\t8. " + Department.DEPARTMENT_8.getName() + ANSI_RESET);
        departmentList.add(RED_BOLD + "\t9. " + Department.DEPARTMENT_9.getName() + ANSI_RESET);
        departmentList.add(RED_BOLD + "\t10. " + Department.DEPARTMENT_10.getName() + ANSI_RESET);
        for (String s : departmentList) {
            System.out.printf("%10s* ", "");
            System.out.println(s);
        }
        System.out.printf("%10s* ", "");
        System.out.print("Podaj dział (Wpisz liczbę) : ");
        Integer department = scn.nextInt();
        System.out.printf("%10s* ", "");
        switch(department) {
            case 1 -> System.out.println("Wybrano : " + Department.DEPARTMENT_1.getName());
            case 2 -> System.out.println("Wybrano : " + Department.DEPARTMENT_2.getName());
            case 3 -> System.out.println("Wybrano : " + Department.DEPARTMENT_3.getName());
            case 4 -> System.out.println("Wybrano : " + Department.DEPARTMENT_4.getName());
            case 5 -> System.out.println("Wybrano : " + Department.DEPARTMENT_5.getName());
            case 6 -> System.out.println("Wybrano : " + Department.DEPARTMENT_6.getName());
            case 7 -> System.out.println("Wybrano : " + Department.DEPARTMENT_7.getName());
            case 8 -> System.out.println("Wybrano : " + Department.DEPARTMENT_8.getName());
            case 9 -> System.out.println("Wybrano : " + Department.DEPARTMENT_9.getName());
            case 10 -> System.out.println("Wybrano : " + Department.DEPARTMENT_10.getName() + "\n");
        }
        @SuppressWarnings("resource")
        Scanner in = new Scanner(new InputStreamReader(System.in));
        System.out.printf("%10s* ", "");
        System.out.print("Podaj początkową datę (DD/MM/YY) : ");
        startDate = in.next();
        System.out.printf("%10s* ", "");
        System.out.print("Podaj końcową datę (DD/MM/YY) : ");
        endDate = in.next();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Calendar start = Calendar.getInstance();
            start.setTime(df.parse(startDate));
            Calendar end = Calendar.getInstance();
            end.setTime(df.parse(endDate));
            int freeDays = 0;
            int freeHoliday = 0;
            while(!start.after(end)) {
                int day = start.get(Calendar.DAY_OF_WEEK);
                if ((day != Calendar.SATURDAY) && (day != Calendar.SUNDAY))
                    freeDays++;
                start.add(Calendar.DATE, 1);
                freeHoliday = (26 - freeDays);
            }
        System.out.println();
        System.out.printf("\n%10s*****************************************************\n", etc);
        System.out.printf("%10s*\t                WNIOSEK URLOPOWY%18s*", etc, etc);
        System.out.printf("\n%10s*****************************************************\n", etc);
        System.out.printf("%10s*\t ", "");
        System.out.println("Dział : " + RED_BOLD + Department.getDepartment(department) + ANSI_RESET);
        System.out.printf("%10s*\t ", "");
        System.out.println("Imię i Nazwisko : " + CYAN_BOLD + name + " " + surname + ANSI_RESET);
        System.out.printf("%10s*\t ", "");
        System.out.println("Wybrałeś : " + GREEN_BOLD + freeDays + " dni" + ANSI_RESET);
        System.out.printf("%10s*\t ", "");
        System.out.println("Zakres : " + GREEN_BOLD + startDate + " do " + endDate + ANSI_RESET);
        System.out.printf("%10s*\t ", "");
        System.out.println("Zostało : " + YELLOW_BOLD + freeHoliday + " dni" + ANSI_RESET);
        System.out.printf("%10s*****************************************************\n", etc);
    }
    private static void calendarPrint() throws IOException {
        try {
            byte[] mapData = Files.readAllBytes(Paths.get("data.json"));
            ObjectMapper objectMapper = new ObjectMapper();
            DayOff[] dayOffArr = objectMapper.readValue(mapData, DayOff[].class);
            List<DayOff> dayOffList = Arrays.asList(dayOffArr);
            for (int i = 0; i < dayOffList.size() ; i++) {
                System.out.printf("%10s", "");
                System.out.println(dayOffList.get(i));
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        }
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
                case 0 -> displayMenu();
            }
        } while (owner != 7);
    }
}
