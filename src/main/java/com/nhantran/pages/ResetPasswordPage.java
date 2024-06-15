package com.nhantran.pages;

import com.nhantran.utils.SeleniumActions;
import org.openqa.selenium.By;

public class ResetPasswordPage extends BasePage {

    private By txtNewPassword = By.xpath("//input[@type='password' and @id='newPassword']");
    private By txtConfirmPassword = By.xpath("//input[@type='password' and @id='confirmPassword']");
    private By txtResetToken = By.xpath("//input[@id='resetToken']");
    private By btnResetPassword = By.xpath("//input[@type='submit' and @value='Reset Password']");
    private By formChangePassword = By.xpath("//form[//*[text()='Password Change Form']]");
    private By lblMessageAboveForm = By.xpath("//p[contains(@class,'message')]");
    private By lblMessageNextToConfirmPassword = By.xpath("//label[@for='confirmPassword' and @class='validation-error']");

    public void resetPassword(String newPassword, String confirmPassword) {
        SeleniumActions.enter(txtNewPassword, newPassword);
        SeleniumActions.enter(txtConfirmPassword, confirmPassword);
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
