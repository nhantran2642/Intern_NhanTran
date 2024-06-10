package com.nhantran.pages;

import com.nhantran.utils.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class HomePage extends BasePage {
    private By welcomeUserMessage = By.xpath("//div[@id='banner']//strong");
    private By title = By.xpath("//h1");

    public Boolean checkWelcomeUserMessageDisplay() {
        return SeleniumActions.findElement(welcomeUserMessage).isDisplayed();
    }

    public boolean checkHomePageTitleDisplay() {
        return SeleniumActions.findElement(title).isDisplayed();
    }


}
