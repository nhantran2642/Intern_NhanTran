package com.nhantran.pages;

import com.nhantran.utils.SeleniumActions;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private By txtUsername = By.id("username");
    private By txtPassword = By.id("password");
    private By btnLogin = By.xpath("//input[@value='login']");
    private By lblErrorMessageAboveForm = By.xpath("//p[@class='message error LoginForm']");
    private By lnkForgotPassword = By.xpath("//a[text()='Forgot Password page']");

    public void login(String username, String password) {
        SeleniumActions.clear(txtUsername);
        SeleniumActions.sendKeysToElement(txtUsername, username);
        SeleniumActions.sendKeysToElement(txtPassword, password);
        SeleniumActions.scrollToElement(btnLogin);
        SeleniumActions.clickElement(btnLogin);
    }

    public boolean isLoginErrorMessageDisplayed() {
        return SeleniumActions.findElement(lblErrorMessageAboveForm).isDisplayed();
    }

    public String getLoginErrorMessage() {
        return SeleniumActions.getElementText(lblErrorMessageAboveForm);
    }

    public void clickForgotPasswordLink(){
        SeleniumActions.clickElement(lnkForgotPassword);
    }

}
