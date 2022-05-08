package com.infoshareacademy.utils;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HolidayUtils {
    public static LocalDate refactorDateHolidayToLocalDate(String iso) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(iso, formatter);
       // LocalDate formattedDate = LocalDate.parse(localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        return localDate;
    }

}
