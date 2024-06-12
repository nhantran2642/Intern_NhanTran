package com.nhantran.enums;

public enum BookTicketComboBoxes {
    DEPART_DATE("Date"),
    DEPART_STATION("DepartStation"),
    ARRIVE_STATION("ArriveStation"),
    SEAT_TYPE("SeatType"),
    AMOUNT("TicketAmount");

    private final String value;

    BookTicketComboBoxes(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
