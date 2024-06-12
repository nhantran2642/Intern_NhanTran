package com.nhantran.enums;

public enum RailwayTabs {
    HOME("Home"),
    FAQ("FAQ"),
    CONTACT("Contact"),
    TIMETABLE("Timetable"),
    TICKET_PRICE("Ticket price"),
    BOOK_TICKET("Book ticket"),
    REGISTER("Register"),
    LOGIN("Login"),
    MY_TICKET("My ticket"),
    CHANGE_PASSWORD("Change password"),
    LOG_OUT("Log out");

    private final String value;

    RailwayTabs(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
