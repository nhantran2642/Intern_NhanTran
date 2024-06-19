package com.nhantran.pages;

import com.nhantran.models.User;
import com.nhantran.utils.controls.*;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private TextBoxes txtUsername = new TextBoxes(By.id("username"));
    private TextBoxes txtPassword = new TextBoxes(By.id("password"));
    private Buttons btnLogin = new Buttons(By.xpath("//input[@value='login']"));
    private Labels lblFormErrorMessage = new Labels(By.xpath("//p[@class='message error LoginForm']"));
    private Links lnkForgotPassword = new Links(By.xpath("//a[text()='Forgot Password page']"));

    public void login(User user) {
        if (user.getEmail() != null) {
            txtUsername.clear();
            txtUsername.enter(user.getEmail());
        }
        if (user.getPassword() != null) {
            txtPassword.clear();
            txtPassword.enter(user.getPassword());
        }
        btnLogin.scrollIntoView();
        btnLogin.click();
    }

    public void loginManyTimes(User user, Integer numberOfTimes) {
        for (int i = 0; i < numberOfTimes - 1; i++) {
            login(user);
        }
    }

    public String getLoginErrorMessage() {
        return lblFormErrorMessage.getText();
    }

    public void clickForgotPasswordLink() {
        lnkForgotPassword.click();
    }

}
