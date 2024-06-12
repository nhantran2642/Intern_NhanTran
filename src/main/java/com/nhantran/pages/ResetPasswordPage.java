package com.nhantran.pages;

import com.nhantran.utils.SeleniumActions;
import org.openqa.selenium.By;

public class ResetPasswordPage extends BasePage {

    By txtNewPassword = By.xpath("//input[@type='password' and @id='newPassword']");
    By txtConfirmPassword = By.xpath("//input[@type='password' and @id='confirmPassword']");
    By txtResetToken = By.xpath("//input[@id='resetToken']");
    By btnResetPassword = By.xpath("//input[@type='submit' and @value='Reset Password']");
    By formChangePassword = By.xpath("//form[//*[text()='Password Change Form']]");
    By lblMessageAboveForm = By.xpath("//p[contains(@class,'message')]");
    By lblMessageNextToConfirmPassword = By.xpath("//label[@for='confirmPassword' and @class='validation-error']");

    public void resetPassword(String newPassword, String confirmPassword) {
        SeleniumActions.sendKeysToElement(txtNewPassword, newPassword);
        SeleniumActions.sendKeysToElement(txtConfirmPassword, confirmPassword);
        SeleniumActions.clickElement(btnResetPassword);
    }

    public boolean isChangePasswordFormDisplayed() {
        return SeleniumActions.findElement(formChangePassword).isDisplayed();
    }

    public String getMessageAboveForm() {
        return SeleniumActions.getElementText(lblMessageAboveForm);
    }

    public String getMessageNextToConfirmPassword() {
        return SeleniumActions.getElementText(lblMessageNextToConfirmPassword);
    }

    public String getResetTokenInTextBox() {
        return SeleniumActions.findElement(txtResetToken).getAttribute("value");
    }
}
