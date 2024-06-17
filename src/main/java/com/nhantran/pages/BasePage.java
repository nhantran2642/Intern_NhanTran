package com.nhantran.pages;

import com.nhantran.enums.RailwayTabs;
import com.nhantran.utils.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class BasePage {

    private String dynMenuTabSelector = "//div[@id='menu']//li/a/span[text()='%s']";

    public void clickTab(RailwayTabs tabName) {
        By tab = By.xpath(String.format(dynMenuTabSelector, tabName.getValue()));
        SeleniumActions.clickElement(tab);
    }

    public boolean isTabDisplayed(RailwayTabs tabName) {
        By tab = By.xpath(String.format(dynMenuTabSelector, tabName.getValue()));
        try {
            return SeleniumActions.findElement(tab).isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }
    }


}
