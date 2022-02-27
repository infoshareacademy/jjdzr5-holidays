package com.infoshareacademy;

import java.util.*;

@SuppressWarnings("ALL")
public class App {
    public static void main(String[] args) {
        // write your code here
        displayMenu();
    }

    public static void displayMenu() {
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
            case 1 -> logoutEmployee();
            case 2 -> logoutOwner();
            case 3 -> System.exit(0);
            default -> System.out.println("Zła opcja, wybierz inną.");
        }
    }
    private static void logoutEmployee() {
        int employee;
        ArrayList<String> list = new ArrayList<>();
        do {
            String etc = "";
            System.out.printf("\n\n%10s*****************************************************\n", etc);
            System.out.printf("%10s*\t               Witaj w Holidays App%15s*", etc, etc);
            System.out.printf("\n%10s*****************************************************\n", etc);
            System.out.printf("%10s*-----------------!!  MENU GŁÓWNE  !!---------------*\n", etc);
            System.out.printf("%10s*****************     PRACOWNIK    ******************\n", etc);
            System.out.printf("%10s*\t1. Wyświetl dostępną ilość dni wolnych%12s*\n", etc, etc);
            System.out.printf("%10s*\t2. Pokaż kalendarz dni wolnych%20s*\n", etc, etc);
            System.out.printf("%10s*\t3. Złóź wniosek urlopowy %25s*\n", etc, etc);
            System.out.printf("%10s*\t4. Znajdz Pracownika %29s*\n", etc, etc);
            System.out.printf("%10s*\t5. Pokaż wszystkich pracowników%19s*\n", etc, etc);
            System.out.printf("%10s*\t6. Wyloguj się %35s*\n", etc, etc);
            System.out.printf("%10s*****************************************************\n", etc);
            System.out.printf("%10s*\tWybierz opcję 1 - 6 : ", etc);
            employee = new Scanner(System.in).nextInt();
            if (employee == 1) {
                System.out.println("Holidays print"); // TODO // Fixed
            } else if (employee == 2) {
                System.out.println("Holidays Calendar"); // TODO // Fixed
            } else if (employee == 3) {
                System.out.println("Holidays Request"); // TODO // Fixed
            } else if (employee == 4) {
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
                if (e == 1) {
                    System.out.print("W bazie danych mamy dopasowanie dla " + searchName);
                } else {
                    System.out.print("Brak dopasowania do " + searchName);
                }
                logoutEmployee();
            } else if (employee == 5) {
                System.out.printf("%10s* ", "");
                System.out.println("Lista Pracowników:");
                for (String s : list) {
                    System.out.printf("%10s* ", "");
                    System.out.println(s);
                }
            } else if (employee == 6) {
                System.out.printf("%10s* ", "");
                System.out.println("Lista Pracowników:");
                for (String s : list) {
                    System.out.printf("%10s* ", "");
                    System.out.println(s);
                }
            }
        } while (employee != 6);

    }
    private static void logoutOwner() {
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
            System.out.printf("%10s*\t1. Wyświetl dostępną ilość dni wolnych%12s*\n", etc, etc);
            System.out.printf("%10s*\t2. Pokaż kalendarz dni wolnych%20s*\n", etc, etc);
            System.out.printf("%10s*\t3. Zarezerwuj urlop %30s*\n", etc, etc);
            System.out.printf("%10s*\t4. Akceptuj wnioski urlopowe %21s*\n", etc, etc);
            System.out.printf("%10s*\t5. Znajdź Pracownika %29s*\n", etc, etc);
            System.out.printf("%10s*\t6. Dodaj Pracownika %30s*\n", etc, etc);
            System.out.printf("%10s*\t7. Pokaż wszystkich pracowników%19s*\n", etc, etc);
            System.out.printf("%10s*\t8. Wyloguj się %35s*\n", etc, etc);
            System.out.printf("%10s*****************************************************\n", etc);
            System.out.printf("%10s*\tWybierz opcję 1 - 8 : ", etc);
            owner = new Scanner(System.in).nextInt();
            if (owner == 1) {
                System.out.println("Holidays print"); // TODO // Fixed
            } else if (owner == 2) {
                System.out.println("Holidays Calendar"); // TODO // Fixed
            } else if (owner == 3) {
                System.out.println("Holidays Request"); // TODO // Fixed
            } else if (owner == 4) {
                System.out.println("Holidays Accept"); // TODO // Fixed
            } else if (owner == 5) {
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
                if (x == 1) {
                    System.out.print("W bazie danych mamy dopasowanie dla " + searchName);
                } else {
                    System.out.print("Brak dopasowania do " + searchName);
                }
                logoutOwner();
            } else if (owner == 6) {
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
            } else if (owner == 7) {
                System.out.printf("%10s* ", "");
                System.out.println("Lista Pracowników:");
                for (String s : list) {
                    System.out.printf("%10s* ", "");
                    System.out.println(s);
                }
            } else if (owner == 8) {
                displayMenu();
            }
        } while (owner != 8);
    }
}
