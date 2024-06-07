package com.nhantran.pages;

import com.nhantran.utils.SeleniumActions;
import org.openqa.selenium.By;

public class BasePage {

    private String railwayTab = "//div[@id='menu']//li/a/span[text()='%s']";

    public void clickTab(String tabName) {
        By tab = By.xpath(String.format(railwayTab, tabName));
        SeleniumActions.clickElement(tab);
    }

}
