package com.nhantran.pages;

import com.nhantran.utils.DriverManager;
import org.openqa.selenium.By;

public class TicketPricePage extends BasePage{
    protected String bookTicketButton = "//tr[td[text()='%s']]//a[text()='Book ticket']";

    public BookTicketPage clickBookTicketButton(String seatType) {
        DriverManager.driver.findElement(By.xpath(String.format(bookTicketButton,seatType))).click();;

        return new BookTicketPage();
    }
}
