package com.nhantran.pages;

import com.nhantran.utils.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class ResetPasswordPage extends BasePage {

    By txtNewPassword = By.xpath("//input[@type='password' and @id='newPassword']");
    By txtConfirmPassword = By.xpath("//input[@type='password' and @id='confirmPassword']");
    By txtResetToken = By.xpath("//input[@id='resetToken']");
    By resetPasswordButton = By.xpath("//input[@type='submit' and @value='Reset Password']");
    By changePasswordForm = By.xpath("//form[//*[text()='Password Change Form']]");
    By messageAboveForm = By.xpath("//p[contains(@class,'message')]");
    By messageNextToConfirmPassword = By.xpath("//label[@for='confirmPassword' and @class='validation-error']");

    public void resetPassword(String newPassword, String confirmPassword){
//        SeleniumActions.waitUntilElementVisible(resetPasswordButton);
        SeleniumActions.sendKeysToElement(txtNewPassword, newPassword);
        SeleniumActions.sendKeysToElement(txtConfirmPassword, confirmPassword);
        SeleniumActions.clickElement(resetPasswordButton);
    }

    public boolean checkChangePasswordFormDisplayed(){
        return SeleniumActions.findElement(changePasswordForm).isDisplayed();
    }

    public String getMessageAboveForm(){
        return SeleniumActions.getElementText(messageAboveForm);
    }

    public String getMessageNextToConfirmPassword(){
        return SeleniumActions.getElementText(messageNextToConfirmPassword);
    }

    public String getResetTokenInTextBox(){
        return SeleniumActions.findElement(txtResetToken).getAttribute("value");
    }
}
