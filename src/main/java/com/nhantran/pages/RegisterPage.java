package com.nhantran.pages;

import com.nhantran.models.User;
import com.nhantran.utils.controls.Button;
import com.nhantran.utils.controls.Label;
import com.nhantran.utils.controls.TextBox;
import org.openqa.selenium.By;

public class RegisterPage extends BasePage {

    private TextBox txtEmail = new TextBox(By.id("email"));
    private TextBox txtPassword = new TextBox(By.id("password"));
    private TextBox txtConfirmPassword = new TextBox(By.id("confirmPassword"));
    private TextBox txtPID = new TextBox(By.id("pid"));
    private Button btnRegister = new Button(By.xpath("//input[@value='Register']"));
    private Label lblErrorAboveForm = new Label(By.xpath("//p[@class='message error']"));
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
        Label lblErrorNextToPassword = new Label(By.xpath(String.format(lblErrorNextToTextBox, "password")));
        return lblErrorNextToPassword.getText();
    }

    public String getErrorMessageNextToPID() {
        Label lblErrorNextToPID = new Label(By.xpath(String.format(lblErrorNextToTextBox, "pid")));
        return lblErrorNextToPID.getText();
    }
}
