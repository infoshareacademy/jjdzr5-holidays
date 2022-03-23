package com.infoshareacademy;

import java.util.Arrays;
import java.util.Map;

@SuppressWarnings("ALL")
public class DayOff {
    public static final String RESET = "\033[0m";  // Text Reset
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    private String name;
    private String description;
    private Map<String, String> country;
    private DateHoliday date;
    private String[] type;
    private String locations;
    private String states;


    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(PURPLE_BOLD + "name : " + RESET).append(GREEN + name + RESET).append("\n");
        sb.append(PURPLE_BOLD + String.format("%24s", "description : ") + RESET).append(GREEN + description + RESET).append("\n");
        sb.append(PURPLE_BOLD + String.format("%20s", "country : ") + RESET).append(GREEN + country + RESET).append("\n");
        sb.append(PURPLE_BOLD + String.format("%17s", "date : ") + RESET).append(GREEN + date + RESET);
        sb.append(PURPLE_BOLD + String.format("%17s", "type : ") + RESET).append(GREEN + Arrays.toString(type) + RESET).append("\n");
        sb.append(PURPLE_BOLD + String.format("%22s", "locations : ") + RESET).append(GREEN + locations + RESET).append("\n");
        sb.append(PURPLE_BOLD + String.format("%19s", "states : ") + RESET).append(GREEN + states + RESET).append("\n");
        return sb.toString();
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Map<String, String> getCountry() { return country; }
    public void setCountry(Map<String, String> country) { this.country = country; }
    public DateHoliday getDate() { return date; }
    public void setDate(DateHoliday date) { this.date = date; }
    public String[] getType() { return type; }
    public void setType(String[] type) { this.type = type; }
    public String getLocations() { return locations; }
    public void setLocations(String locations) { this.locations = locations; }
    public String getStates() { return states; }
    public void setStates(String states) { this.states = states; }
}