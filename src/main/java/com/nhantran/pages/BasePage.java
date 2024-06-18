package com.nhantran.pages;

import com.nhantran.enums.RailwayTabs;
import com.nhantran.utils.actions.BaseActions;
import com.nhantran.utils.actions.LinkActions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class BasePage {

    private String dynMenuTabSelector = "//div[@id='menu']//li/a/span[text()='%s']";

    public void clickTab(RailwayTabs tabName) {
        By tab = By.xpath(String.format(dynMenuTabSelector, tabName.getValue()));
        LinkActions.click(tab);
    }

    public boolean isTabDisplayed(RailwayTabs tabName) {
        By tab = By.xpath(String.format(dynMenuTabSelector, tabName.getValue()));
        try {
            return BaseActions.isElementDisplayed(tab);
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
