package com.nhantran.pages;

import com.nhantran.utils.DriverManager;
import com.nhantran.utils.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookTicketSuccessPage extends BasePage{

    private String bookedTicketTableCell = "//td[count(//tr/th[text()='%s']/preceding-sibling::th)+1]";
    private By headerBookingSuccessfully = By.xpath("//h1");
    private By ticketInfoDepartStation = By.xpath(String.format(bookedTicketTableCell, "Depart Station"));
    private By ticketInfoArrivalStation = By.xpath(String.format(bookedTicketTableCell, "Arrive Station"));
    private By ticketInfoSeatType = By.xpath(String.format(bookedTicketTableCell, "Seat Type"));
    private By ticketInfoDepartDate = By.xpath(String.format(bookedTicketTableCell, "Depart Date"));
    private By ticketInfoAmount = By.xpath(String.format(bookedTicketTableCell, "Amount"));

    public String getSuccessfulMessage() {
        return this.getInfomation(SeleniumActions.findElement(headerBookingSuccessfully));
    }

    public String getDepartStation() {
        return this.getInfomation(SeleniumActions.findElement(ticketInfoDepartStation));
    }

    public String getArrivalStation() {
        return this.getInfomation(SeleniumActions.findElement(ticketInfoArrivalStation));
    }

    public String getSeatType() {
        return this.getInfomation(SeleniumActions.findElement(ticketInfoSeatType));
    }

    public String getDepartDate() {
        return this.getInfomation(SeleniumActions.findElement(ticketInfoDepartDate));
    }

    public String getTicketAmount() {
        return this.getInfomation(SeleniumActions.findElement(ticketInfoAmount));
    }

    private String getInfomation(WebElement element){
        return SeleniumActions.getElementText(element);
    }
}
