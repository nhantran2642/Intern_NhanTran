package com.nhantran.pages;

import com.nhantran.models.User;
import com.nhantran.utils.actions.BaseActions;
import com.nhantran.utils.actions.ButtonActions;
import com.nhantran.utils.actions.TextBoxActions;
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
            TextBoxActions.enter(txtEmail, user.getEmail());
        }
        if (user.getPassword() != null) {
            TextBoxActions.enter(txtPassword, user.getPassword());
        }
        if (user.getConfirmPassword() != null) {
            TextBoxActions.enter(txtConfirmPassword, user.getConfirmPassword());
        }
        if (user.getPid() != null) {
            TextBoxActions.enter(txtPID, user.getPid());
        }
        BaseActions.scrollToElement(btnRegister);
        ButtonActions.click(btnRegister);
    }

    public String getErrorMessageAboveRegisterForm() {
        return BaseActions.getElementText(lblErrorAboveForm);
    }

    public String getErrorMessageNextToPassword() {
        return BaseActions.getElementText(By.xpath(String.format(lblErrorNextToTextBox, "password")));
    }

    public String getErrorMessageNextToPID() {
        return BaseActions.getElementText(By.xpath(String.format(lblErrorNextToTextBox, "pid")));
    }
}
