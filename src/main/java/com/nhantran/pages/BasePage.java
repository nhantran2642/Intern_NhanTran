package com.nhantran.pages;

import com.nhantran.utils.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class BasePage {

    private String railwayTab = "//div[@id='menu']//li/a/span[text()='%s']";

    public void clickTab(String tabName) {
        By tab = By.xpath(String.format(railwayTab, tabName));
        SeleniumActions.clickElement(tab);
    }

    public boolean isTabDisplayed(String tabName) {
        By tab = By.xpath(String.format(railwayTab, tabName));
        try {
            SeleniumActions.findElement(tab);
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }
}
