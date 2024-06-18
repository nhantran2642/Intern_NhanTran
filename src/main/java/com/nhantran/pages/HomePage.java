package com.nhantran.pages;

import com.nhantran.utils.actions.BaseActions;
import com.nhantran.utils.actions.LinkActions;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private By welcomeUserMessage = By.xpath("//div[@id='banner']//strong");
    private By title = By.xpath("//h1");
    private By createAccountHyperlink = By.xpath("//a[text()='create an account']");

    public boolean isWelcomeUserMessageDisplayed() {
        return BaseActions.isElementDisplayed(welcomeUserMessage);
    }

    public boolean isHomePageTitleDisplayed() {
        return BaseActions.isElementDisplayed(title);
    }

    public void clickCreateAccountHyperlink() {
        LinkActions.click(createAccountHyperlink);
    }

}
