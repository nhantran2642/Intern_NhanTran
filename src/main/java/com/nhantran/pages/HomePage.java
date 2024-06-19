package com.nhantran.pages;

import com.nhantran.utils.controls.Label;
import com.nhantran.utils.controls.Link;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private Label welcomeUserMessage = new Label(By.xpath("//div[@id='banner']//strong"));
    private Label title = new Label(By.xpath("//h1"));
    private Link createAccountHyperlink = new Link(By.xpath("//a[text()='create an account']"));

    public boolean isWelcomeUserMessageDisplayed() {
        return welcomeUserMessage.isDisplayed();
    }

    public boolean isHomePageTitleDisplayed() {
        return title.isDisplayed();
    }

    public void clickCreateAccountHyperlink() {
        createAccountHyperlink.click();
    }

}
