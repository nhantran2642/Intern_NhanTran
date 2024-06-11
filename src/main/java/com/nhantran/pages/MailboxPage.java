package com.nhantran.pages;

import com.nhantran.utils.SeleniumActions;
import org.openqa.selenium.By;

public class MailboxPage {
    By scrambleAddressCheckbox = By.xpath("//input[@type='checkbox' and following-sibling::label[text()=' Scramble Address']]");
    By txtMail = By.xpath("//span[@id='email-widget']");
    By confirmMail = By.xpath("//table[@id='email_table']//tr[contains(@class, 'mail')]//td[contains(.,'Please confirm your account')]");
    By confirmLink = By.xpath("//*[@class='email_body']//a[contains(@href,'confirmationCode')]");
    By resetPasswordMail = By.xpath("//tr[contains(@class,'email_unread')]//td[contains(.,'Please reset your password')]");
    By resetPasswordLink = By.xpath("//*[@class='email_body']//a[contains(@href,'PasswordReset')]");
    By mailUsernameBox = By.xpath("//span[@id='inbox-id']");
    By mailUsernameInput = By.xpath("//span[@id='inbox-id']/input[@type='text']");
    By setMailUsernameButton = By.xpath("//span[@id='inbox-id']/button[text()='Set']");
    By mailDomainSelectBox = By.xpath("//select[@id='gm-host-select']");
    By emailBody = By.xpath("//div[@class='email_body']");


    public void clickScrambleAddressCheckbox() {
        SeleniumActions.clickElement(scrambleAddressCheckbox);
    }

    public String getMail() {
        return SeleniumActions.getElementText(txtMail);
    }

    public void clickConfirmLinkInMail() {
        SeleniumActions.waitUntilElementVisible(confirmMail);
        SeleniumActions.clickElement(confirmMail);
        SeleniumActions.waitUntilElementVisible(confirmLink);
        SeleniumActions.clickElement(confirmLink);
    }

    public void clickResetPasswordMail() {
        SeleniumActions.waitUntilElementVisible(resetPasswordMail);
        SeleniumActions.clickElement(resetPasswordMail);
    }

    public void clickResetPasswordLinkInMail() {
        SeleniumActions.waitUntilElementVisible(resetPasswordLink);
        SeleniumActions.clickElement(resetPasswordLink);
    }

    public void setMail(String mail) {
        String username = getMailUsername(mail);
        String domain = getMailDomain(mail);
        SeleniumActions.clickElement(mailUsernameBox);
        SeleniumActions.clear(mailUsernameInput);
        SeleniumActions.sendKeysToElement(mailUsernameInput, username);
        SeleniumActions.clickElement(setMailUsernameButton);
        SeleniumActions.selectByText(mailDomainSelectBox, domain);
    }

    private String getMailUsername(String mail) {
        String[] mailItem = mail.split("@");
        return mailItem[0];
    }

    private String getMailDomain(String mail) {
        String[] mailItem = mail.split("@");
        return mailItem[1];
    }

    public String getResetPasswordToken(){
        String mailText = SeleniumActions.getElementText(emailBody);
        String[] parts = mailText.split("The token is: ");
        if (parts.length > 1) {
            String[] tokenParts = parts[1].split("\\.");
            return tokenParts[0].trim();
        }
        return "";
    }
}
