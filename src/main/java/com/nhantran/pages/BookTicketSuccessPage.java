package com.nhantran.pages;

import com.nhantran.utils.controls.Label;
import org.openqa.selenium.By;

public class BookTicketSuccessPage extends BasePage {

    private String dynCellBookedTicketTable = "//td[count(//tr/th[text()='%s']/preceding-sibling::th)+1]";
    private String dynHeaderBookingSuccessfully = "//h1[text()='%s']";
    private By lblTicketDepartStation = By.xpath(String.format(dynCellBookedTicketTable, "Depart Station"));
    private By lblTicketArrivalStation = By.xpath(String.format(dynCellBookedTicketTable, "Arrive Station"));
    private By lblTicketSeatType = By.xpath(String.format(dynCellBookedTicketTable, "Seat Type"));
    private By lblTicketDepartDate = By.xpath(String.format(dynCellBookedTicketTable, "Depart Date"));
    private By lblTicketAmount = By.xpath(String.format(dynCellBookedTicketTable, "Amount"));

    public boolean isSuccessfulMessageDisplayed(String message) {
        Label successfulMessage = new Label(By.xpath(String.format(dynHeaderBookingSuccessfully, message)));
        return successfulMessage.isDisplayed();
    }

    public String getDepartStation() {
        Label tkDepartStation = new Label(lblTicketDepartStation);
        return tkDepartStation.getText();
    }

    public String getArrivalStation() {
        Label tkArrivalStation = new Label(lblTicketArrivalStation);
        return tkArrivalStation.getText();
    }

    public String getSeatType() {
        Label tkSeatType = new Label(lblTicketSeatType);
        return tkSeatType.getText();
    }

    public String getDepartDate() {
        Label tkDepartDate = new Label(lblTicketDepartDate);
        return tkDepartDate.getText();
    }

    public Integer getTicketAmount() {
        Label tkAmount = new Label(lblTicketAmount);
        return Integer.parseInt(tkAmount.getText());
    }
}
