package com.nhantran.pages;

import com.nhantran.enums.BookTicketComboBoxes;
import com.nhantran.enums.RailwayStations;
import com.nhantran.enums.SeatTypes;
import com.nhantran.models.Ticket;
import com.nhantran.utils.controls.Button;
import com.nhantran.utils.controls.ComboBox;
import org.openqa.selenium.By;

import java.util.EnumSet;

public class BookTicketPage extends BasePage {
    private String dynCbbBookTicket = "//select[@name='%s']";
    Button btnBookTicket = new Button(By.xpath("//input[@value='Book ticket']"));

    private void selectCombobox(BookTicketComboBoxes comboBoxName, String value) {
        ComboBox cbbBookTicket = new ComboBox(By.xpath(String.format(dynCbbBookTicket, comboBoxName.getValue())));
        cbbBookTicket.scrollIntoView();
        cbbBookTicket.select(value);
    }

    private void selectDepartDate(String date) {
        if (date != null)
            this.selectCombobox(BookTicketComboBoxes.DEPART_DATE, date);
    }

    private void selectDepartStation(RailwayStations departStation) {
        if (departStation != null)
            this.selectCombobox(BookTicketComboBoxes.DEPART_STATION, departStation.getValue());
    }

    private void selectArrivalStation(RailwayStations arrivalStation) {
        if (arrivalStation != null) {
            this.selectCombobox(BookTicketComboBoxes.ARRIVE_STATION, arrivalStation.getValue());
        }
    }

    private void selectSeatType(SeatTypes seatType) {
        if (seatType != null)
            this.selectCombobox(BookTicketComboBoxes.SEAT_TYPE, seatType.getValue());
    }

    private void selectAmount(Integer amount) {
        if (amount > 0)
            this.selectCombobox(BookTicketComboBoxes.AMOUNT, String.valueOf(amount));
    }

    private void clickBookTicketButton() {
        btnBookTicket.scrollIntoView();
        btnBookTicket.click();
    }

    public void bookTicket(Ticket ticket) {
        selectDepartDate(ticket.getDepartDate());
        selectDepartStation(ticket.getDepartStation());
        selectSeatType(ticket.getSeatType());
        selectAmount(ticket.getTicketAmount());
        selectArrivalStation(ticket.getArrivalStation());
        clickBookTicketButton();
    }

    private static final EnumSet<BookTicketComboBoxes> ALLOWED_STATIONS =
            EnumSet.of(BookTicketComboBoxes.DEPART_STATION, BookTicketComboBoxes.ARRIVE_STATION);

    public String getStation(BookTicketComboBoxes comboBoxName) {
        if (!ALLOWED_STATIONS.contains(comboBoxName)) {
            throw new IllegalArgumentException("Invalid combobox: " + comboBoxName);
        }
        ComboBox comboBox = new ComboBox(By.xpath(String.format(dynCbbBookTicket, comboBoxName.getValue())));
        return comboBox.getSelectedOption();
    }


}
