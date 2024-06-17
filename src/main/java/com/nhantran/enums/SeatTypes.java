package com.nhantran.enums;

public enum SeatTypes {

    HARD_SEAT("Hard seat"),
    SOFT_SEAT("Soft seat"),
    SOFT_SEAT_AIR_CONDITIONER("Soft seat with air conditioner"),
    HARD_BED("Hard bed"),
    SOFT_BED("Soft bed"),
    SOFT_BED_AIR_CONDITIONER("Soft bed with air conditioner");

    private final String value;

    SeatTypes(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
