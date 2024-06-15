package com.nhantran.pages;

import com.nhantran.models.User;
import com.nhantran.utils.SeleniumActions;
import org.openqa.selenium.By;

public class RegisterPage extends BasePage {

    private By txtEmail = By.id("email");
    private By txtPassword = By.id("password");
    private By txtConfirmPassword = By.id("confirmPassword");
    private By txtPID = By.id("pid");
    private By btnRegister = By.xpath("//input[@value='Register']");
    private By lblErrorAboveForm = By.xpath("//p[@class='message error']");
    private String lblErrorNextToTextBox = "//label[@class='validation-error' and @for='%s']";

    public void register(User user) {
        if (user.getEmail() != null) {
            SeleniumActions.enter(txtEmail, user.getEmail());
        }
        if (user.getPassword() != null) {
            SeleniumActions.enter(txtPassword, user.getPassword());
        }
        if (user.getConfirmPassword() != null) {
            SeleniumActions.enter(txtConfirmPassword, user.getConfirmPassword());
        }
        if (user.getPid() != null) {
            SeleniumActions.enter(txtPID, user.getPid());
        }
        SeleniumActions.scrollToElement(btnRegister);
        SeleniumActions.clickElement(btnRegister);
    }

    public String getErrorMessageAboveRegisterForm() {
        return SeleniumActions.getElementText(lblErrorAboveForm);
    }

    public String getErrorMessageNextToPassword() {
        return SeleniumActions.getElementText(By.xpath(String.format(lblErrorNextToTextBox, "password")));
    }

    public String getErrorMessageNextToPID() {
        return SeleniumActions.getElementText(By.xpath(String.format(lblErrorNextToTextBox, "pid")));
    }
}
