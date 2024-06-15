package com.nhantran.pages;

import com.nhantran.enums.BookTicketComboBoxes;
import com.nhantran.enums.RailwayStations;
import com.nhantran.enums.SeatTypes;
import com.nhantran.models.Tickets;
import com.nhantran.utils.SeleniumActions;
import org.openqa.selenium.By;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.EnumSet;

public class BookTicketPage extends BasePage {
    private String selectBox = "//select[@name='%s']";
    private String bookTicketButton = "//input[@value='Book ticket']";

    private void selectBookTicketInfo(BookTicketComboBoxes comboBoxName, String value) {
        if (value != null) {
            By bookTicketSelectBox = By.xpath(String.format(selectBox, comboBoxName.getValue()));
            SeleniumActions.scrollToElement(bookTicketSelectBox);
            SeleniumActions.selectByText(bookTicketSelectBox, value);
        }
    }

    private void selectDepartDate(String date) {
        if (date != null)
            this.selectBookTicketInfo(BookTicketComboBoxes.DEPART_DATE, date);
    }

    private void selectDepartStation(RailwayStations departStation) {
        if (departStation != null)
            this.selectBookTicketInfo(BookTicketComboBoxes.DEPART_STATION, departStation.getValue());
    }

    private void selectArrivalStation(RailwayStations arrivalStation) {
        if (arrivalStation != null)
            this.selectBookTicketInfo(BookTicketComboBoxes.ARRIVE_STATION, arrivalStation.getValue());
    }

    private void selectSeatType(SeatTypes seatType) {
        if (seatType != null)
            this.selectBookTicketInfo(BookTicketComboBoxes.SEAT_TYPE, seatType.getValue());
    }

    private void selectAmount(Integer amount) {
        if (amount > 0)
            this.selectBookTicketInfo(BookTicketComboBoxes.AMOUNT, String.valueOf(amount));
    }

    private void clickBookTicketButton() {
        SeleniumActions.scrollToElement(By.xpath(bookTicketButton));
        SeleniumActions.clickElement(By.xpath(bookTicketButton));
    }

    public void bookTicket(Tickets ticket) {
        selectDepartDate(ticket.getDepartDate());
        selectDepartStation(ticket.getDepartStation());
        selectArrivalStation(ticket.getArrivalStation());
        selectSeatType(ticket.getSeatType());
        selectAmount(ticket.getTicketAmount());
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

    public String calculateNextDate(int numberOfNextDays) {
        LocalDate currentDate = LocalDate.now();
        LocalDate nextDate = currentDate.plusDays(numberOfNextDays);
        return nextDate.format(DateTimeFormatter.ofPattern("M/d/yyyy"));
    }
}
