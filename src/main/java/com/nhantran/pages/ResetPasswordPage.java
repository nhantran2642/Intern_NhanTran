package com.nhantran.pages;

import com.nhantran.utils.actions.BaseActions;
import com.nhantran.utils.actions.ButtonActions;
import com.nhantran.utils.actions.TextBoxActions;
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
        TextBoxActions.enter(txtNewPassword, newPassword);
        TextBoxActions.enter(txtConfirmPassword, confirmPassword);
        ButtonActions.click(btnResetPassword);
    }

    public boolean isChangePasswordFormDisplayed() {
        return BaseActions.isElementDisplayed(formChangePassword);
    }

    public String getMessageAboveForm() {
        return BaseActions.getElementText(lblMessageAboveForm);
    }

    public String getMessageNextToConfirmPassword() {
        return BaseActions.getElementText(lblMessageNextToConfirmPassword);
    }

    public String getResetTokenInTextBox() {
        return BaseActions.findElement(txtResetToken).getAttribute("value");
    }
}
