package com.nhantran.pages;

import com.nhantran.utils.controls.Buttons;
import com.nhantran.utils.controls.Forms;
import com.nhantran.utils.controls.Labels;
import com.nhantran.utils.controls.TextBoxes;
import org.openqa.selenium.By;

public class ResetPasswordPage extends BasePage {

    private TextBoxes txtNewPassword = new TextBoxes(By.xpath("//input[@type='password' and @id='newPassword']"));
    private TextBoxes txtConfirmPassword = new TextBoxes(By.xpath("//input[@type='password' and @id='confirmPassword']"));
    private TextBoxes txtResetToken = new TextBoxes(By.xpath("//input[@id='resetToken']"));
    private Buttons btnResetPassword = new Buttons(By.xpath("//input[@type='submit' and @value='Reset Password']"));
    private Forms formChangePassword = new Forms(By.xpath("//form[//*[text()='Password Change Form']]"));
    private Labels lblMessageAboveForm = new Labels(By.xpath("//p[contains(@class,'message')]"));
    private Labels lblMessageNextToConfirmPassword = new Labels(By.xpath("//label[@for='confirmPassword' and @class='validation-error']"));

    public void resetPassword(String newPassword, String confirmPassword) {
        txtNewPassword.enter(newPassword);
        txtConfirmPassword.enter(confirmPassword);
        btnResetPassword.click();
    }

    public boolean isChangePasswordFormDisplayed() {
        return formChangePassword.isDisplayed();
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
