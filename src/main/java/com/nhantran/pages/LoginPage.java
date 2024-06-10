package com.nhantran.pages;

import com.nhantran.utils.SeleniumActions;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private By txtUsername = By.id("username");
    private By txtPassword = By.id("password");
    private By btnLogin = By.xpath("//input[@value='login']");
    private By formErrorMessage = By.xpath("//p[@class='message error LoginForm']");

    public void login(String username, String password) {
        SeleniumActions.clear(txtUsername);
        SeleniumActions.sendKeysToElement(txtUsername, username);
        SeleniumActions.sendKeysToElement(txtPassword, password);
        SeleniumActions.scrollToElement(btnLogin);
        SeleniumActions.clickElement(btnLogin);
    }

    public boolean checkLoginErrorMessageDisplay(){
        return SeleniumActions.findElement(formErrorMessage).isDisplayed();
    }

    public String getLoginErrorMessage(){
        return SeleniumActions.getElementText(formErrorMessage);
    }


}
