package com.nhantran.pages;

import com.nhantran.models.User;
import com.nhantran.utils.controls.Buttons;
import com.nhantran.utils.controls.Labels;
import com.nhantran.utils.controls.TextBoxes;
import org.openqa.selenium.By;

public class RegisterPage extends BasePage {

    private TextBoxes txtEmail = new TextBoxes(By.id("email"));
    private TextBoxes txtPassword = new TextBoxes(By.id("password"));
    private TextBoxes txtConfirmPassword = new TextBoxes(By.id("confirmPassword"));
    private TextBoxes txtPID = new TextBoxes(By.id("pid"));
    private Buttons btnRegister = new Buttons(By.xpath("//input[@value='Register']"));
    private Labels lblErrorAboveForm = new Labels(By.xpath("//p[@class='message error']"));
    private String lblErrorNextToTextBox = "//label[@class='validation-error' and @for='%s']";

    public void register(User user) {
        if (user.getEmail() != null) {
            txtEmail.enter(user.getEmail());
        }
        if (user.getPassword() != null) {
            txtPassword.enter(user.getPassword());
        }
        if (user.getConfirmPassword() != null) {
            txtConfirmPassword.enter(user.getConfirmPassword());
        }
        if (user.getPid() != null) {
            txtPID.enter(user.getPid());
        }
        btnRegister.scrollIntoView();
        btnRegister.click();
    }

    public String getErrorMessageAboveRegisterForm() {
        return lblErrorAboveForm.getText();
    }

    public String getErrorMessageNextToPassword() {
        Labels lblErrorNextToPassword = new Labels(By.xpath(String.format(lblErrorNextToTextBox, "password")));
        return lblErrorNextToPassword.getText();
    }

    public String getErrorMessageNextToPID() {
        Labels lblErrorNextToPID = new Labels(By.xpath(String.format(lblErrorNextToTextBox, "pid")));
        return lblErrorNextToPID.getText();
    }
}
