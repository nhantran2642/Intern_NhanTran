package com.nhantran.enums;

public enum RailwayStations {
    SAI_GON("Sài Gòn"),
    PHAN_THIET("Phan Thiết"),
    NHA_TRANG("Nha Trang"),
    DA_NANG("Đà Nẵng"),
    HUE("Huế"),
    QUANG_NGAI("Quảng Ngãi");

    private final String value;

    RailwayStations(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
