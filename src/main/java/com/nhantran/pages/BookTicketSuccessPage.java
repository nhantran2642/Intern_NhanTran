package com.nhantran.pages;

import com.nhantran.utils.DriverManager;
import org.openqa.selenium.By;

public class BookTicketSuccessPage extends BasePage{

    private static final String bookedTicketTableCell = "//td[count(//tr/th[text()='%s']/preceding-sibling::th)+1]";
    By headerBookingSuccessfully = By.xpath("//h1");
    By ticketInfoDepartStation = By.xpath(String.format(bookedTicketTableCell, "Depart Station"));
    By ticketInfoArrivalStation = By.xpath(String.format(bookedTicketTableCell, "Arrive Station"));
    By ticketInfoSeatType = By.xpath(String.format(bookedTicketTableCell, "Seat Type"));
    By ticketInfoDepartDate = By.xpath(String.format(bookedTicketTableCell, "Depart Date"));
    By ticketInfoAmount = By.xpath(String.format(bookedTicketTableCell, "Amount"));

    public String getSuccessfulMessage() {
        return DriverManager.driver.findElement(headerBookingSuccessfully).getText();
    }

    public String getDepartStation() {
        return DriverManager.driver.findElement(ticketInfoDepartStation).getText();
    }

    public String getArrivalStation() {
        return DriverManager.driver.findElement(ticketInfoArrivalStation).getText();
    }

    public String getSeatType() {
        return DriverManager.driver.findElement(ticketInfoSeatType).getText();
    }

    public String getDepartDate() {
        return DriverManager.driver.findElement(ticketInfoDepartDate).getText();
    }

    public String getTicketAmount() {
        return DriverManager.driver.findElement(ticketInfoAmount).getText();
    }
}
