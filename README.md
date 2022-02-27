# jjdzr5-holidays

# jjdzr5-holidays


1. Pokaż kalendarz dni wolnych, dni wolne pobrane z pliku JSON (class Calendar)
2. Złóż wniosek o urlop
    1. class Employee
        1. int idEmployee - field
    2. class Holiday (field idHoliday, field idEmployee)

Złóż wniosek o urlop -> podaja imię i nazwisko i dział (dział jako ENUM, gdzie pownno być wpisanych kilka działów) -> podaj datę rozpoczęcia urlopu ->
-> podaj datę zakończenia urlopu -> zatwierdzamy i dalej mamy nastepujące możliwości/funkcjonalność:

- podajemy w podsumowaniu ilość całkowitych dni urlopu, biorąc pod uwagę podany zakres dat, czyli: "W podanym zakresie dat jest X dni roboczych. 1. Wyślij wniosek  2. Popraw"
- jeżeli User kliknie "Popraw" to przechodzimy do punktu "podaj datę rozpoczęcia urlopu"
- może się okazać, że w podanym zakresie dat, już istnieje jego urlop, którego wniosek już złożył wcześniej


------------------------------------------------------------

3. Wyświetlenie wszystkich złożonych wniosków urlopowych
4. wyszukanie urlopu danego pracownika po imieniu lub nazwisku lub imieniu i nazwisku
5. Filtorwanie listy wszystkich wniosków urlopowych po dacie rozpoczęcia, dacie zakończenie lub po obu datach, czyli zakresie
6. Zarządzanie uelementami:
    1. usuwanie wniosku urlopowego (usunięcie elementu z listy)
    2. edycja - opcjonalne wykonanie tego punktu:
        1. Znajdż wnioski urlopowe pracownika
        2. Wybierz konkretny wiosek urlopowy z ewentualnej listy kilku wniosków tego samego pracownika
        3. Akcje do wyboru: edytuj lub usuń
        4. User wybrał edytuj, ponownie powinien podać datę rozpoczęcia i zakończenia urlopu, czyli wykonujemy tutaj część punktu 2 (podaj datę rozpoczęcia urlopu ->
           -> podaj datę zakończenia urlopu -> zatwierdzamy i dalej......)
        5. Po zatwierdzeniu zmian, stary wniosek usuwamy z listy a do listy dodajemy nowy wniosek

7. Sposób sortowania wyświetlonej listy wniosków urlopowych, pobieramy z pliku properties.