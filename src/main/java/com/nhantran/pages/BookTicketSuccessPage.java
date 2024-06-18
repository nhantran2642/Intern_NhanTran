package com.nhantran.pages;

import com.nhantran.utils.actions.BaseActions;
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
        By successfulMessage = By.xpath(String.format(dynHeaderBookingSuccessfully, message));
        return BaseActions.isElementDisplayed(successfulMessage);
    }

    public String getDepartStation() {
        return this.getInformation(lblTicketDepartStation);
    }

    public String getArrivalStation() {
        return this.getInformation(lblTicketArrivalStation);
    }

    public String getSeatType() {
        return this.getInformation(lblTicketSeatType);
    }

    public String getDepartDate() {
        return this.getInformation(lblTicketDepartDate);
    }

    public Integer getTicketAmount() {
        return Integer.parseInt(this.getInformation(lblTicketAmount));
    }

    private String getInformation(By element) {
        return BaseActions.getElementText(element);
    }
}
