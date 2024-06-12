package com.nhantran.pages;

import com.nhantran.utils.SeleniumActions;
import org.openqa.selenium.By;

public class TicketPricePage extends BasePage {

    private String btnBookTicket = "//tr[td[text()='%s']]//a[text()='Book ticket']";
    private String lblPageTitle = "//h1[text()='%s']";
    private String lblPriceOfSeatType = "//table[@class='MyTable MedTable']//th[normalize-space()='Price (VND)']//following-sibling::td[count(//td[text()='%s']/preceding-sibling::td)+1]";

    By headerSeatPriceTable = By.xpath("//table[@class='MyTable MedTable']//th[contains(text(),'Ticket price from')]");

    public void clickBookTicketButton(String seatType) {
        SeleniumActions.clickElement(By.xpath(String.format(btnBookTicket, seatType)));
    }

    public boolean isPageTitleDisplayed(String pageTitle) {
        return SeleniumActions.findElement(By.xpath(String.format(lblPageTitle, pageTitle))).isDisplayed();
    }

    public String getHeaderOfSeatPriceTable() {
        return SeleniumActions.getElementText(headerSeatPriceTable);
    }

    public Integer getPriceOfSeatType(String seatType) {
        return Integer.parseInt(SeleniumActions.getElementText(By.xpath(String.format(lblPriceOfSeatType, seatType))));
    }
}
