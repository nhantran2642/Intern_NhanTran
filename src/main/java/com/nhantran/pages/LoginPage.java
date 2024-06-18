package com.nhantran.pages;

import com.nhantran.models.User;
import com.nhantran.utils.actions.BaseActions;
import com.nhantran.utils.actions.ButtonActions;
import com.nhantran.utils.actions.LinkActions;
import com.nhantran.utils.actions.TextBoxActions;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private By txtUsername = By.id("username");
    private By txtPassword = By.id("password");
    private By btnLogin = By.xpath("//input[@value='login']");
    private By lblFormErrorMessage = By.xpath("//p[@class='message error LoginForm']");
    private By lnkForgotPassword = By.xpath("//a[text()='Forgot Password page']");

    public void login(User user) {
        if (user.getEmail() != null) {
            TextBoxActions.clear(txtUsername);
            TextBoxActions.enter(txtUsername, user.getEmail());
        }
        if (user.getPassword() != null) {
            TextBoxActions.clear(txtPassword);
            TextBoxActions.enter(txtPassword, user.getPassword());
        }
        BaseActions.scrollToElement(btnLogin);
        ButtonActions.click(btnLogin);
    }

    public void loginManyTimes(User user, Integer numberOfTimes) {
        for (int i = 0; i < numberOfTimes - 1; i++) {
            login(user);
        }
    }

    public boolean isLoginErrorMessageDisplayed() {
        return BaseActions.isElementDisplayed(lblFormErrorMessage);
    }

    public String getLoginErrorMessage() {
        return BaseActions.getElementText(lblFormErrorMessage);
    }

    public void clickForgotPasswordLink() {
        LinkActions.click(lnkForgotPassword);
    }

}
