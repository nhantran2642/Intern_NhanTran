package com.nhantran.chapter10;

import com.nhantran.base.TestBase;
import com.nhantran.enums.RailwayTabs;
import com.nhantran.pages.*;
import com.nhantran.utils.Constants;
import com.nhantran.utils.Messages;
import com.nhantran.utils.SeleniumActions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ResetPasswordTest extends TestBase {
    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();
    private MailboxPage mailboxPage = new MailboxPage();
    private ForgetPasswordPage forgetPasswordPage = new ForgetPasswordPage();
    private ResetPasswordPage resetPasswordPage = new ResetPasswordPage();

    @DataProvider(name = "resetPasswordData")
    public Object[][] dataTestTC010AndTC011() {
        return new Object[][]{
                {Constants.VALID_USERNAME, Constants.VALID_PASSWORD, Constants.VALID_PASSWORD, Messages.MSG_ERROR_NEW_PASSWORD_SAME_OLD_PASSWORD, null},
                {Constants.VALID_USERNAME, Constants.VALID_PASSWORD + "a", Constants.VALID_PASSWORD + "abc", Messages.MSG_ERROR_ABOVE_RESET_PASSWORD_FORM, Messages.MSG_ERROR_CONFIRM_PASSWORD_NOT_MATCH_PASSWORD}
        };
    }

    @Test(dataProvider = "resetPasswordData", description = "Reset password shows error if the new password is same as current password or not matches the confirm password")
    public void TC010_011_ErrorMessageDisplayWhenNewPasswordSameAsOldPasswordOrNotMatchConfirmPassword(String username, String password, String confirmPassword, String expectedMessageAboveForm, String expectedMessageNextToTextBox) {
        String railwayWindow = SeleniumActions.getWindowHandle();
        homePage.clickTab(RailwayTabs.LOGIN);
        loginPage.clickForgotPasswordLink();
        forgetPasswordPage.submitPasswordResetInstructionsForm(username);
        SeleniumActions.openWebInNewTab(Constants.TEMPORARY_MAIL_URL);
        String mailWindow = SeleniumActions.getWindowHandle();
        mailboxPage.setMail(username);
        mailboxPage.clickResetPasswordMail();
        String resetToken = mailboxPage.getResetPasswordToken();
        mailboxPage.clickResetPasswordLinkInMail();
        SeleniumActions.switchToRemainingTab(railwayWindow, mailWindow);
        Assert.assertTrue(resetPasswordPage.isChangePasswordFormDisplayed());
        Assert.assertEquals(resetPasswordPage.getResetTokenInTextBox(), resetToken);
        resetPasswordPage.resetPassword(password, confirmPassword);
        Assert.assertEquals(resetPasswordPage.getMessageAboveForm(), expectedMessageAboveForm);
        Assert.assertEquals(resetPasswordPage.getMessageNextToConfirmPassword(), expectedMessageNextToTextBox);
    }
}
