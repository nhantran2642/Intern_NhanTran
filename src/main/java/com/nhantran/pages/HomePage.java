package com.nhantran.pages;

import com.nhantran.utils.controls.Labels;
import com.nhantran.utils.controls.Links;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private Labels welcomeUserMessage = new Labels(By.xpath("//div[@id='banner']//strong"));
    private Labels title = new Labels(By.xpath("//h1"));
    private Links createAccountHyperlink = new Links(By.xpath("//a[text()='create an account']"));

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
