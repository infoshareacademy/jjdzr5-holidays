package com.infoshareacademy.filter;

import com.infoshareacademy.DateHoliday;
import com.infoshareacademy.api.DayOffData;
import com.infoshareacademy.domain.DayOff;
import com.infoshareacademy.tools.UserInteraction;


import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Filter {

    public ArrayList<DayOff> filterHolidayByType () {
        Stream<DayOff> dayOffStream = DayOffData.getDyOffList().stream();
        String filteredType = UserInteraction.getTypeOfHoliday();
        List<DayOff> filteredList;
        filteredList = dayOffStream.filter(dayOff -> {
            return Arrays.stream(dayOff.getType()).anyMatch((s) -> s.equals(filteredType));
        }).collect(Collectors.toList());

        return new ArrayList<DayOff>(filteredList);
    }

    public ArrayList<DayOff> filterHolidayByDates () {
        Stream<DayOff> dayOffStream = DayOffData.getDyOffList().stream();
        List<LocalDate> dates = getStartAndFinishDate();
        List<DayOff> filteredList;
        filteredList = dayOffStream.filter(dayOff -> {
            return dayOff.getDate().refactorToLocalDate().isAfter(dates.get(0));
        }).filter(dayOff -> {
            return dayOff.getDate().refactorToLocalDate().isBefore(dates.get(1));
        }).collect(Collectors.toList());

        return (ArrayList<DayOff>) filteredList;
    }


    private List<LocalDate> getStartAndFinishDate () {
        boolean inputDatesAreIncorrect = true;
        LocalDate start;
        LocalDate finish;
        do {
            start = UserInteraction.getLocalDate();
            finish = UserInteraction.getLocalDate();
            if (Period.between(finish, start).isNegative()) {
                inputDatesAreIncorrect = false;
            } else {
                System.out.println("Podaj daty w kolejności chronologicznej.");
            }
        } while (inputDatesAreIncorrect);

        return List.of(start, finish);
    }


}
