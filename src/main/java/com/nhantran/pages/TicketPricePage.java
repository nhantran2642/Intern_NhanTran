package com.nhantran.pages;

import com.nhantran.utils.SeleniumActions;
import org.openqa.selenium.By;

public class TicketPricePage extends BasePage {

    private String bookTicketButton = "//tr[td[text()='%s']]//a[text()='Book ticket']";

    public void clickBookTicketButton(String seatType) {
        SeleniumActions.clickElement(By.xpath(String.format(bookTicketButton, seatType)));
    }
}
