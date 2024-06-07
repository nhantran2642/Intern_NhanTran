package com.nhantran.pages;

import com.nhantran.utils.DriverManager;
import com.nhantran.utils.SeleniumActions;
import org.openqa.selenium.By;

public class BookTicketSuccessPage extends BasePage{

    private String bookedTicketTableCell = "//td[count(//tr/th[text()='%s']/preceding-sibling::th)+1]";
    private By headerBookingSuccessfully = By.xpath("//h1");
    private By ticketInfoDepartStation = By.xpath(String.format(bookedTicketTableCell, "Depart Station"));
    private By ticketInfoArrivalStation = By.xpath(String.format(bookedTicketTableCell, "Arrive Station"));
    private By ticketInfoSeatType = By.xpath(String.format(bookedTicketTableCell, "Seat Type"));
    private By ticketInfoDepartDate = By.xpath(String.format(bookedTicketTableCell, "Depart Date"));
    private By ticketInfoAmount = By.xpath(String.format(bookedTicketTableCell, "Amount"));

    public String getSuccessfulMessage() {
        return this.getTicketInfo(headerBookingSuccessfully);
    }

    public String getDepartStation() {
        return this.getTicketInfo(ticketInfoDepartStation);
    }

    public String getArrivalStation() {
        return this.getTicketInfo(ticketInfoArrivalStation);
    }

    public String getSeatType() {
        return this.getTicketInfo(ticketInfoSeatType);
    }

    public String getDepartDate() {
        return this.getTicketInfo(ticketInfoDepartDate);
    }

    public String getTicketAmount() {
        return this.getTicketInfo(ticketInfoAmount);
    }

    private String getTicketInfo(By element){
        return SeleniumActions.getElementText(element);
    }
}
