package com.nhantran.pages;

import com.nhantran.utils.SeleniumActions;
import org.openqa.selenium.By;

public class BookTicketSuccessPage extends BasePage {

    private String celBookedTicketTable = "//td[count(//tr/th[text()='%s']/preceding-sibling::th)+1]";
    private By hdrBookingSuccessfully = By.xpath("//h1");
    private By lblTicketDepartStation = By.xpath(String.format(celBookedTicketTable, "Depart Station"));
    private By lblTicketArrivalStation = By.xpath(String.format(celBookedTicketTable, "Arrive Station"));
    private By lblTicketSeatType = By.xpath(String.format(celBookedTicketTable, "Seat Type"));
    private By lblTicketDepartDate = By.xpath(String.format(celBookedTicketTable, "Depart Date"));
    private By lblTicketAmount = By.xpath(String.format(celBookedTicketTable, "Amount"));

    public String getSuccessfulMessage() {
        return this.getInformation(hdrBookingSuccessfully);
    }

    public boolean isSuccessfulMessageDisplayed(String message) {
        return SeleniumActions.findElement(By.xpath(String.format("//h1[text()='%s']", message))).isDisplayed();
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
        return SeleniumActions.getElementText(element);
    }
}
