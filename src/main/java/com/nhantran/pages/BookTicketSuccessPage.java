package com.nhantran.pages;

import com.nhantran.utils.controls.Labels;
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
        Labels successfulMessage = new Labels(By.xpath(String.format(dynHeaderBookingSuccessfully, message)));
        return successfulMessage.isDisplayed();
    }

    public String getDepartStation() {
        Labels tkDepartStation = new Labels(lblTicketDepartStation);
        return tkDepartStation.getText();
    }

    public String getArrivalStation() {
        Labels tkArrivalStation = new Labels(lblTicketArrivalStation);
        return tkArrivalStation.getText();
    }

    public String getSeatType() {
        Labels tkSeatType = new Labels(lblTicketSeatType);
        return tkSeatType.getText();
    }

    public String getDepartDate() {
        Labels tkDepartDate = new Labels(lblTicketDepartDate);
        return tkDepartDate.getText();
    }

    public Integer getTicketAmount() {
        Labels tkAmount = new Labels(lblTicketAmount);
        return Integer.parseInt(tkAmount.getText());
    }
}
