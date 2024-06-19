package com.nhantran.pages;

import com.nhantran.enums.RailwayTabs;
import com.nhantran.utils.controls.Links;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class BasePage {

    private String dynMenuTabSelector = "//div[@id='menu']//li/a/span[text()='%s']";

    public void clickTab(RailwayTabs tabName) {
        Links tab = new Links(By.xpath(String.format(dynMenuTabSelector, tabName.getValue())));
        tab.click();
    }

    public boolean isTabDisplayed(RailwayTabs tabName) {
        Links tab = new Links(By.xpath(String.format(dynMenuTabSelector, tabName.getValue())));
        try {
            return tab.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
