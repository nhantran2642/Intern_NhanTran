package com.nhantran.pages;

import com.nhantran.utils.DriverManager;
import org.openqa.selenium.By;

public class BasePage {

    protected String railwayTab = "//div[@id='menu']//li/a/span[text()='%s']";

    public void clickTab(String tabName){
        By tab = By.xpath(String.format(railwayTab, tabName));
        DriverManager.driver.findElement(tab).click();
    }
}
