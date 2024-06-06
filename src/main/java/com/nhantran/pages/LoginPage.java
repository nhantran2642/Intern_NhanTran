package com.nhantran.pages;

import com.nhantran.utils.DriverManager;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    //protected By tabLogin = By.xpath(String.format(this.railwayTab, "Login"));
    protected By txtUsername = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.xpath("//input[@value='login']");

    public HomePage login(String username, String password){
        DriverManager.driver.findElement(txtUsername).sendKeys(username);
        DriverManager.driver.findElement(txtPassword).sendKeys(password);
        DriverManager.driver.findElement(btnLogin).click();

        return new HomePage();
    }

}
