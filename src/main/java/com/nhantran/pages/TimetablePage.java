package com.nhantran.pages;

import com.nhantran.utils.DriverManager;
import org.openqa.selenium.By;

public class TimetablePage extends BasePage{

    protected String checkPriceLink = "//tr[td[text()='%s' and following-sibling::td[text()='%s']]]//a[text()='check price']";

    public TicketPricePage clickCheckPriceLink(String departStation, String arrivalStation){
        DriverManager.driver.findElement(By.xpath(String.format(checkPriceLink, departStation, arrivalStation))).click();
        return new TicketPricePage();
    }
}
