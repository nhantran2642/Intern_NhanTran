package com.nhantran.enums;

public enum FilterComboBoxes {
    DEPART_STATION("FilterDpStation"),
    ARRIVE_STATION("FilterArStation"),
    STATUS("FilterStatus");

    private String value;

    FilterComboBoxes(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
