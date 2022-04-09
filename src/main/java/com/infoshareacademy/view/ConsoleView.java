package com.infoshareacademy.view;

import com.infoshareacademy.domain.DayOff;
import de.vandermeer.asciitable.AsciiTable;

import java.util.ArrayList;

public class ConsoleView {

    public static void displayList(ArrayList<DayOff> dayOffList) {
        AsciiTable asciiTable = new AsciiTable();
        asciiTable.addRule();
        asciiTable.addRow("Name", "Description", "Country", "Date", "Type", "Locations", "Sates");
        asciiTable.addRule();
        for (DayOff dayOff : dayOffList) {
            asciiTable.addRow(
                    dayOff.getName(),
                    dayOff.getDescription(),
                    dayOff.getCountry().get("name"),
                    dayOff.getDate().getIso(),
                    dayOff.getType()[0],
                    dayOff.getLocations(),
                    dayOff.getStates()
            );
        }
        asciiTable.addRule();
        System.out.println(asciiTable.render());
    }
}