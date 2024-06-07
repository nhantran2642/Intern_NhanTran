package com.nhantran.pages;

import com.nhantran.utils.DriverManager;
import com.nhantran.utils.SeleniumActions;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private By txtUsername = By.id("username");
    private By txtPassword = By.id("password");
    private By btnLogin = By.xpath("//input[@value='login']");

    public void login(String username, String password) {
        SeleniumActions.sendKeysToElement(txtUsername, username);
        SeleniumActions.sendKeysToElement(txtPassword, password);
        SeleniumActions.clickElement(btnLogin);
    }


}
