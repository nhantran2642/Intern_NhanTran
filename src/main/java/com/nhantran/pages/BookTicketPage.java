package com.nhantran.pages;

import com.nhantran.enums.BookTicketComboBoxes;
import com.nhantran.enums.RailwayStations;
import com.nhantran.enums.SeatTypes;
import com.nhantran.utils.SeleniumActions;
import org.openqa.selenium.By;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.EnumSet;

public class BookTicketPage extends BasePage {
    private String selectBox = "//select[@name='%s']";
    private String bookTicketButton = "//input[@value='Book ticket']";

    private void selectBookTicketInfo(BookTicketComboBoxes comboBoxName, String value) {
        By bookTicketSelectBox = By.xpath(String.format(selectBox, comboBoxName.getValue()));
        SeleniumActions.selectByText(bookTicketSelectBox, value);
    }

    private void selectDepartDate(String date) {
        this.selectBookTicketInfo(BookTicketComboBoxes.DEPART_DATE, date);
    }

    private void selectDepartStation(String departStation) {
        this.selectBookTicketInfo(BookTicketComboBoxes.DEPART_STATION, departStation);
    }

    private void selectArrivalStation(String arrivalStation) {
        this.selectBookTicketInfo(BookTicketComboBoxes.ARRIVE_STATION, arrivalStation);
    }

    private void selectSeatType(String seatType) {
        this.selectBookTicketInfo(BookTicketComboBoxes.SEAT_TYPE, seatType);
    }

    private void selectAmount(Integer amount) {
        this.selectBookTicketInfo(BookTicketComboBoxes.AMOUNT, String.valueOf(amount));
    }

    private void clickBookTicketButton() {
        SeleniumActions.clickElement(By.xpath(bookTicketButton));
    }

    public void bookTicket(String departDate, RailwayStations departStation, RailwayStations arrivalStation, SeatTypes seatType, int amount) {
        if (!departDate.isEmpty()) {
            selectDepartDate(departDate);
        }
        if (departStation != null) {
            selectDepartStation(departStation.getValue());
        }
        if (arrivalStation != null) {
            selectArrivalStation(arrivalStation.getValue());
        }
        if (seatType != null) {
            selectSeatType(seatType.getValue());
        }
        if (amount > 0) {
            selectAmount(amount);
        }
        clickBookTicketButton();
    }

    private static final EnumSet<BookTicketComboBoxes> ALLOWED_STATIONS =
            EnumSet.of(BookTicketComboBoxes.DEPART_STATION, BookTicketComboBoxes.ARRIVE_STATION);

    public String getStation(BookTicketComboBoxes comboBoxName) {
        if (!ALLOWED_STATIONS.contains(comboBoxName)) {
            throw new IllegalArgumentException("Invalid combobox: " + comboBoxName);
        }
        return SeleniumActions.getSelectedOption(By.xpath(String.format(selectBox, comboBoxName.getValue())));
    }

}
