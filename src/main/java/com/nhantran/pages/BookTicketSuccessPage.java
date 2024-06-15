package com.nhantran.pages;

import com.nhantran.utils.SeleniumActions;
import org.openqa.selenium.By;

public class BookTicketSuccessPage extends BasePage {

    private String bookedTicketTableCell = "//td[count(//tr/th[text()='%s']/preceding-sibling::th)+1]";
    private By headerBookingSuccessfully = By.xpath("//h1");
    private By ticketInfoDepartStation = By.xpath(String.format(bookedTicketTableCell, "Depart Station"));
    private By ticketInfoArrivalStation = By.xpath(String.format(bookedTicketTableCell, "Arrive Station"));
    private By ticketInfoSeatType = By.xpath(String.format(bookedTicketTableCell, "Seat Type"));
    private By ticketInfoDepartDate = By.xpath(String.format(bookedTicketTableCell, "Depart Date"));
    private By ticketInfoAmount = By.xpath(String.format(bookedTicketTableCell, "Amount"));

    public String getSuccessfulMessage() {
        return this.getInformation(headerBookingSuccessfully);
    }

    public boolean isSuccessfulMessageDisplayed(String message) {
        return SeleniumActions.findElement(By.xpath(String.format("//h1[text()='%s']", message))).isDisplayed();
    }

    public String getDepartStation() {
        return this.getInformation(ticketInfoDepartStation);
    }

    public String getArrivalStation() {
        return this.getInformation(ticketInfoArrivalStation);
    }

    public String getSeatType() {
        return this.getInformation(ticketInfoSeatType);
    }

    public String getDepartDate() {
        return this.getInformation(ticketInfoDepartDate);
    }

    public Integer getTicketAmount() {
        return Integer.parseInt(this.getInformation(ticketInfoAmount));
    }

    private String getInformation(By element) {
        return SeleniumActions.getElementText(element);
    }
}
