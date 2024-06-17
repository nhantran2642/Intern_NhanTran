package com.nhantran.pages;

import com.nhantran.utils.SeleniumActions;
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


    public void clickScrambleAddressCheckbox() {
        SeleniumActions.clickElement(chkScrambleAddress);
    }

    public String getMail() {
        return SeleniumActions.getElementText(txtMail);
    }

    public void clickConfirmLinkInMail() {
        SeleniumActions.waitUntilElementVisible(mailConfirm);
        SeleniumActions.clickElement(mailConfirm);
        SeleniumActions.waitUntilElementVisible(lnkConfirm);
        SeleniumActions.clickElement(lnkConfirm);
    }

    public void clickResetPasswordMail() {
        SeleniumActions.waitUntilElementVisible(mailResetPassword);
        SeleniumActions.clickElement(mailResetPassword);
    }

    public void clickResetPasswordLinkInMail() {
        SeleniumActions.waitUntilElementVisible(lnkResetPassword);
        SeleniumActions.clickElement(lnkResetPassword);
    }

    public void setMail(String mail) {
        String username = getMailUsername(mail);
        String domain = getMailDomain(mail);
        SeleniumActions.clickElement(btnMailUsername);
        SeleniumActions.clear(txtMailUsername);
        SeleniumActions.enter(txtMailUsername, username);
        SeleniumActions.clickElement(btnSetMailUsername);
        SeleniumActions.selectByText(cbbMailDomain, domain);
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
        String mailText = SeleniumActions.getElementText(mailBody);
        String[] parts = mailText.split("The token is: ");
        if (parts.length > 1) {
            String[] tokenParts = parts[1].split("\\.");
            return tokenParts[0].trim();
        }
        return "";
    }
}
