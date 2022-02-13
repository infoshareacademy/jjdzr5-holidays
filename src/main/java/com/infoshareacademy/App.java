package com.infoshareacademy;

import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        // write your code here
        displayMenu();
    }

    public static void displayMenu() {
        int option;
        String etc="";
        System.out.printf("\n\n%10s****************************************************\n", etc);
        System.out.printf("%10s*-----------------!! MENU URLOPY !!----------------*\n", etc);
        System.out.printf("%10s****************************************************\n", etc);
        System.out.printf("%10s*\t1. Wyświetl ilość dni wolnych%20s*\n", etc, etc);
        System.out.printf("%10s*\t2. Pokaż dni świąteczne (wolne)%18s*\n", etc, etc);
        System.out.printf("%10s*\t3. Dodaj pracownika%30s*\n", etc, etc);
        System.out.printf("%10s*\t4. Znajdź pracownika%29s*\n", etc, etc);
        System.out.printf("%10s*\t5. Zaloguj się%35s*\n", etc, etc);
        System.out.printf("%10s*\t6. Wyjście%39s*\n", etc, etc);
        System.out.printf("%10s****************************************************\n", etc);
        System.out.printf("%10s*\tWybierz opcję 1 - 5 : ",etc);
        option = new Scanner(System.in).nextInt();
        switch (option) {
            case 1 -> printDays();
            case 2 -> printFreeDays();
            case 3 -> addPerson();
            case 4 -> findPerson();
            case 5 -> menuLogout();
            case 6 -> System.exit(0);
            default -> System.out.println("Zła opcja, wybierz inną.");
        }
    }
    private static void menuLogout() {
    }
    private static void findPerson() {
    }
    private static void addPerson() {
    }
    private static void printFreeDays() {
    }
    private static void printDays() {
        String etc="";
        System.out.printf("\n%10s****************************************************\n", etc);
        System.out.printf("%10s*-----------------!! MENU DNI !!-------------------*\n", etc);
        System.out.printf("%10s****************************************************\n", etc);
        System.out.printf("%10s*\t1. Liczba dostępnych dni%25s*\n", etc, etc);
        System.out.printf("%10s*\t2. Powrót%40s*\n", etc, etc);
        System.out.printf("%10s****************************************************\n", etc);
    }
}
