package com.nhantran.pages;

import com.nhantran.models.User;
import com.nhantran.utils.SeleniumActions;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private By txtUsername = By.id("username");
    private By txtPassword = By.id("password");
    private By btnLogin = By.xpath("//input[@value='login']");
    private By formErrorMessage = By.xpath("//p[@class='message error LoginForm']");
    private By forgotPasswordLink = By.xpath("//a[text()='Forgot Password page']");

    public void login(User user) {
        if (user.getEmail() != null) {
            SeleniumActions.clear(txtUsername);
            SeleniumActions.enter(txtUsername, user.getEmail());
        }
        if (user.getPassword() != null) {
            SeleniumActions.clear(txtPassword);
            SeleniumActions.enter(txtPassword, user.getPassword());
        }
        SeleniumActions.scrollToElement(btnLogin);
        SeleniumActions.clickElement(btnLogin);
    }

    public void loginManyTimes(User user, Integer numberOfTimes) {
        for (int i = 0; i < numberOfTimes - 1; i++) {
            login(user);
        }
    }

    public boolean isLoginErrorMessageDisplayed() {
        return SeleniumActions.findElement(formErrorMessage).isDisplayed();
    }

    public String getLoginErrorMessage() {
        return SeleniumActions.getElementText(formErrorMessage);
    }

    public void clickForgotPasswordLink() {
        SeleniumActions.clickElement(forgotPasswordLink);
    }

}
