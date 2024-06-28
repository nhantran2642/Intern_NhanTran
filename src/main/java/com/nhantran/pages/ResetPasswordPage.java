package com.nhantran.pages;

import com.nhantran.utils.DriverManager;
import com.nhantran.utils.controls.*;
import org.openqa.selenium.By;

public class ResetPasswordPage extends BasePage {

    private TextBox txtNewPassword = new TextBox(By.xpath("//input[@type='password' and @id='newPassword']"));
    private TextBox txtConfirmPassword = new TextBox(By.xpath("//input[@type='password' and @id='confirmPassword']"));
    private TextBox txtResetToken = new TextBox(By.xpath("//input[@id='resetToken']"));
    private Button btnResetPassword = new Button(By.xpath("//input[@type='submit' and @value='Reset Password']"));
    private Label lblMessageAboveForm = new Label(By.xpath("//p[contains(@class,'message')]"));
    private Label lblMessageNextToConfirmPassword = new Label(By.xpath("//label[@for='confirmPassword' and @class='validation-error']"));
    private By formChangePassword = By.xpath("//form[//*[text()='Password Change Form']]");

    public void resetPassword(String newPassword, String confirmPassword) {
        txtNewPassword.enter(newPassword);
        txtConfirmPassword.enter(confirmPassword);
        btnResetPassword.click();
    }

    public boolean isChangePasswordFormDisplayed() {
        return DriverManager.driver.findElement(formChangePassword).isDisplayed();
    }

    public String getMessageAboveForm() {
        return lblMessageAboveForm.getText();
    }

    public String getMessageNextToConfirmPassword() {
        return lblMessageNextToConfirmPassword.getText();
    }

    public String getResetTokenInTextBox() {
        return txtResetToken.findElement().getAttribute("value");
    }
}
