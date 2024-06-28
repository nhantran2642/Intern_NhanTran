package com.nhantran.pages;

import com.nhantran.enums.BookTicketComboBoxes;
import com.nhantran.enums.FilterComboBoxes;
import com.nhantran.enums.RailwayStations;
import com.nhantran.enums.Status;
import com.nhantran.models.Ticket;
import com.nhantran.utils.controls.*;
import org.openqa.selenium.By;

public class MyTicketPage extends BasePage {

    private String dynButtonCancelTicket = "//table[@class='MyTable']//tr[" +
            "td[count(//tr/th[text()='Depart Station']/preceding-sibling::th)+1][text()='%s'] and " +
            "td[count(//tr/th[text()='Arrive Station']/preceding-sibling::th)+1][text()='%s'] and " +
            "td[count(//tr/th[text()='Seat Type']/preceding-sibling::th)+1][text()='%s'] and " +
            "td[count(//tr/th[text()='Depart Date']/preceding-sibling::th)+1][text()='%s'] and " +
            "td[count(//tr/th[text()='Amount']/preceding-sibling::th)+1][text()='%d']" +
            "]/td[count(//tr/th[text()='Operation']/preceding-sibling::th)+1]/input[@type='button' and @value='Cancel']";

    private String dynTicketRow = "//table[@class='MyTable']//tr[" +
            "td[count(//tr/th[text()='Depart Station']/preceding-sibling::th)+1][text()='%s'] and " +
            "td[count(//tr/th[text()='Arrive Station']/preceding-sibling::th)+1][text()='%s'] and " +
            "td[count(//tr/th[text()='Seat Type']/preceding-sibling::th)+1][text()='%s'] and " +
            "td[count(//tr/th[text()='Depart Date']/preceding-sibling::th)+1][text()='%s'] and " +
            "td[count(//tr/th[text()='Amount']/preceding-sibling::th)+1][text()='%d']]";

    private String dynFilteredTicketRow = "//table[@class='MyTable']//tr[" +
            "td[text()='%s' and following-sibling::td[text()='%s' " +
            "and following-sibling::td[text()='%s' " +
            "and following-sibling::td[text()='%s']]]]]";

    private String dynCbbFilter = "//select[@name='%s']";
    private Button btnApplyFilter = new Button(By.xpath("//input[@value='Apply filter']"));
    private TextBox txtFilterDepartDate = new TextBox(By.xpath("//input[@name='FilterDpDate']"));

    public void cancelTicket(Ticket ticket) {
        Button btnCancelTicket = new Button(By.xpath(String.format(dynButtonCancelTicket, ticket.getDepartStation().getValue(), ticket.getArrivalStation().getValue(), ticket.getSeatType().getValue(), ticket.getDepartDate(), ticket.getTicketAmount())));
        btnCancelTicket.click();
    }

    public void acceptToCancelTicket() {
        Alert alert = new Alert();
        alert.acceptAlert();
    }

    public boolean isCanceledTicketDisplayed(Ticket ticket) {
        Label tkRow = new Label(By.xpath(String.format(dynTicketRow, ticket.getDepartStation().getValue(), ticket.getArrivalStation().getValue(), ticket.getSeatType().getValue(), ticket.getDepartDate(), ticket.getTicketAmount())));
        return tkRow.isDisplayed();
    }

    public boolean isFilteredTicketDisplayed(Ticket ticket, Status status) {
        Label tkRow = new Label(By.xpath(String.format(dynFilteredTicketRow, ticket.getDepartStation().getValue(), ticket.getArrivalStation().getValue(), ticket.getDepartDate(), status.getValue())));
        return tkRow.isDisplayed();
    }

    public void filter(RailwayStations departStation, RailwayStations arriveStation, String departDate, Status ticketStatus){
        selectDepartStation(departStation);
        selectArrivalStation(arriveStation);
        txtFilterDepartDate.enter(departDate);
        selectTicketStatus(ticketStatus);
        btnApplyFilter.click();
    }

    private void selectCombobox(FilterComboBoxes comboBoxName, String value) {
        ComboBox cbbBookTicket = new ComboBox(By.xpath(String.format(dynCbbFilter, comboBoxName.getValue())));
        cbbBookTicket.scrollIntoView();
        cbbBookTicket.select(value);
    }

    private void selectDepartStation(RailwayStations departStation) {
        if (departStation != null)
            this.selectCombobox(FilterComboBoxes.DEPART_STATION, departStation.getValue());
    }

    private void selectArrivalStation(RailwayStations arrivalStation) {
        if (arrivalStation != null) {
            this.selectCombobox(FilterComboBoxes.ARRIVE_STATION, arrivalStation.getValue());
        }
    }

    private void selectTicketStatus(Status status) {
        if (status != null) {
            this.selectCombobox(FilterComboBoxes.STATUS, status.getValue());
        }
    }
}
