package com.nhantran.pages;

import com.nhantran.utils.SeleniumActions;
import org.openqa.selenium.By;

public class RegisterPage extends BasePage {

    private By txtEmail = By.id("email");
    private By txtPassword = By.id("password");
    private By txtConfirmPassword = By.id("confirmPassword");
    private By txtPID = By.id("pid");
    private By btnRegister = By.xpath("//input[@value='Register']");
    private By formErrorMessage = By.xpath("//p[@class='message error']");
    private String errorLabel = "//label[@class='validation-error' and @for='%s']";

    public void register(String email, String password, String confirmPassword, String pid) {
        SeleniumActions.clear(txtEmail);
        SeleniumActions.sendKeysToElement(txtEmail, email);
        SeleniumActions.sendKeysToElement(txtPassword, password);
        SeleniumActions.sendKeysToElement(txtConfirmPassword, confirmPassword);
        SeleniumActions.sendKeysToElement(txtPID, pid);
        SeleniumActions.scrollToElement(btnRegister);
        SeleniumActions.clickElement(btnRegister);
    }

    public String getErrorMessageAboveRegisterForm(){
        return SeleniumActions.getElementText(formErrorMessage);
    }

    public String getErrorMessageNextToPassword(){
        return SeleniumActions.getElementText(By.xpath(String.format(errorLabel,"password")));
    }

    public String getErrorMessageNextToPID(){
        return SeleniumActions.getElementText(By.xpath(String.format(errorLabel,"pid")));
    }
}
