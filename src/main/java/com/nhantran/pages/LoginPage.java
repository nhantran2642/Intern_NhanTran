package com.nhantran.pages;

import com.nhantran.models.User;
import com.nhantran.utils.controls.*;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private TextBox txtUsername = new TextBox(By.id("username"));
    private TextBox txtPassword = new TextBox(By.id("password"));
    private Button btnLogin = new Button(By.xpath("//input[@value='login']"));
    private Label lblFormErrorMessage = new Label(By.xpath("//p[@class='message error LoginForm']"));
    private Link lnkForgotPassword = new Link(By.xpath("//a[text()='Forgot Password page']"));

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
