package com.nhantran.pages;

import com.nhantran.utils.actions.*;
import org.openqa.selenium.By;

public class MailboxPage {
    private By chkScrambleAddress = By.xpath("//input[@type='checkbox' and following-sibling::label[text()=' Scramble Address']]");
    private By txtMail = By.xpath("//span[@id='email-widget']");
    private By mailConfirm = By.xpath("//table[@id='email_table']//tr[contains(@class, 'mail')]//td[contains(.,'Please confirm your account')]");
    private By lnkConfirm = By.xpath("//*[@class='email_body']//a[contains(@href,'confirmationCode')]");
    private By mailResetPassword = By.xpath("//tr[contains(@class,'email_unread')]//td[contains(.,'Please reset your password')]");
    private By lnkResetPassword = By.xpath("//*[@class='email_body']//a[contains(@href,'PasswordReset')]");
    private By btnMailUsername = By.xpath("//span[@id='inbox-id']");
    private By txtMailUsername = By.xpath("//span[@id='inbox-id']/input[@type='text']");
    private By btnSetMailUsername = By.xpath("//span[@id='inbox-id']/button[text()='Set']");
    private By cbbMailDomain = By.xpath("//select[@id='gm-host-select']");
    private By mailBody = By.xpath("//div[@class='email_body']");


    public void uncheckScrambleAddressCheckbox() {
        CheckboxActions.uncheck(chkScrambleAddress);
    }

    public String getMail() {
        return BaseActions.getElementText(txtMail);
    }

    public void clickConfirmLinkInMail() {
        BaseActions.waitUntilElementVisible(mailConfirm);
        LinkActions.click(mailConfirm);
        BaseActions.waitUntilElementVisible(lnkConfirm);
        LinkActions.click(lnkConfirm);
    }

    public void clickResetPasswordMail() {
        BaseActions.waitUntilElementVisible(mailResetPassword);
        LinkActions.click(mailResetPassword);
    }

    public void clickResetPasswordLinkInMail() {
        BaseActions.waitUntilElementVisible(lnkResetPassword);
        LinkActions.click(lnkResetPassword);
    }

    public void setMail(String mail) {
        String username = getMailUsername(mail);
        String domain = getMailDomain(mail);
        ButtonActions.click(btnMailUsername);
        TextBoxActions.clear(txtMailUsername);
        TextBoxActions.enter(txtMailUsername, username);
        ButtonActions.click(btnSetMailUsername);
        ComboBoxActions.select(cbbMailDomain, domain);
    }

    private String getMailUsername(String mail) {
        String[] mailItem = mail.split("@");
        return mailItem[0];
    }

    private String getMailDomain(String mail) {
        String[] mailItem = mail.split("@");
        return mailItem[1];
    }

    public String getResetPasswordToken() {
        String mailText = BaseActions.getElementText(mailBody);
        String[] parts = mailText.split("The token is: ");
        if (parts.length > 1) {
            String[] tokenParts = parts[1].split("\\.");
            return tokenParts[0].trim();
        }
        return "";
    }
}
