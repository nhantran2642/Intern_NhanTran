package com.nhantran.enums;

public enum Status {
    EXPIRED("Expired"),
    NEW("New"),
    PAID("Paid");

    private String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
