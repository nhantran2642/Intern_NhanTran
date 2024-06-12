package com.nhantran.pages;

import com.nhantran.utils.SeleniumActions;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private By lblWelcomeUser = By.xpath("//div[@id='banner']//strong");
    private By title = By.xpath("//h1");
    private By lnkCreateAccount = By.xpath("//a[text()='create an account']");

    public boolean isWelcomeUserMessageDisplayed() {
        return SeleniumActions.findElement(lblWelcomeUser).isDisplayed();
    }

    public boolean isHomePageTitleDisplayed() {
        return SeleniumActions.findElement(title).isDisplayed();
    }

    public void clickCreateAccountHyperlink(){
        SeleniumActions.clickElement(lnkCreateAccount);
    }

}
