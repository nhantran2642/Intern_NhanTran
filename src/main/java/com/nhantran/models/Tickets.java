package com.nhantran.models;

import com.nhantran.enums.RailwayStations;
import com.nhantran.enums.SeatTypes;

public class Tickets {

    private String departDate;
    private RailwayStations departStation;
    private RailwayStations arrivalStation;
    private SeatTypes seatType;
    private Integer ticketAmount;

    public Tickets(String departDate, SeatTypes seatType, Integer ticketAmount) {
        this.departDate = departDate;
        this.seatType = seatType;
        this.ticketAmount = ticketAmount;
    }

    public Tickets(String departDate, Integer ticketAmount) {
        this.departDate = departDate;
        this.ticketAmount = ticketAmount;
    }

    public Tickets(String departDate, RailwayStations departStation, RailwayStations arrivalStation, SeatTypes seatType, Integer ticketAmount) {
        this.departDate = departDate;
        this.departStation = departStation;
        this.arrivalStation = arrivalStation;
        this.seatType = seatType;
        this.ticketAmount = ticketAmount;
    }

    public String getDepartDate() {
        return departDate;
    }

    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }

    public RailwayStations getDepartStation() {
        return departStation;
    }

    public void setDepartStation(RailwayStations departStation) {
        this.departStation = departStation;
    }

    public RailwayStations getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(RailwayStations arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    public SeatTypes getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatTypes seatType) {
        this.seatType = seatType;
    }

    public Integer getTicketAmount() {
        return ticketAmount;
    }

    public void setTicketAmount(Integer ticketAmount) {
        this.ticketAmount = ticketAmount;
    }
}
