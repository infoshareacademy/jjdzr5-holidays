package com.infoshareacademy.domain;

import java.util.ArrayList;

public class DayOff {
    String name;
    String description;
    Country country;
    Date date;
    ArrayList<String> type;
    String locations;
    String states;

    public DayOff(String name, String description, Country country, Date date, ArrayList<String> type, String locations, String states) {
        this.name = name;
        this.description = description;
        this.country = country;
        this.date = date;
        this.type = type;
        this.locations = locations;
        this.states = states;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<String> getType() {
        return type;
    }

    public void setType(ArrayList<String> type) {
        this.type = type;
    }

    public String getLocations() {
        return locations;
    }

    public void setLocations(String locations) {
        this.locations = locations;
    }

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states;
    }
}
