package com.nhantran.pages;

import com.nhantran.enums.RailwayTabs;
import com.nhantran.utils.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class BasePage {

    private String railwayTab = "//div[@id='menu']//li/a/span[text()='%s']";

    public void clickTab(RailwayTabs tabName) {
        By tab = By.xpath(String.format(railwayTab, tabName.getValue()));
        SeleniumActions.clickElement(tab);
    }

    public boolean isTabDisplayed(RailwayTabs tabName) {
        By tab = By.xpath(String.format(railwayTab, tabName.getValue()));
        try {
            SeleniumActions.findElement(tab);
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }





}
