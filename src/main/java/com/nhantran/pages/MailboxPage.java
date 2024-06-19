package com.nhantran.pages;

import com.nhantran.utils.controls.*;
import org.openqa.selenium.By;

public class MailboxPage {
    private CheckBox chkScrambleAddress = new CheckBox(By.xpath("//input[@type='checkbox' and following-sibling::label[text()=' Scramble Address']]"));
    private Label tmpMail = new Label(By.xpath("//span[@id='email-widget']"));
    private Label mailContent = new Label(By.xpath("//div[@class='email_body']"));
    private Link mailConfirm = new Link(By.xpath("//table[@id='email_table']//tr[contains(@class, 'mail')]//td[contains(.,'Please confirm your account')]"));
    private Link lnkConfirm = new Link(By.xpath("//*[@class='email_body']//a[contains(@href,'confirmationCode')]"));
    private Link lnkResetPassword = new Link(By.xpath("//*[@class='email_body']//a[contains(@href,'PasswordReset')]"));
    private Link mailResetPassword = new Link(By.xpath("//tr[contains(@class,'email_unread')]//td[contains(.,'Please reset your password')]"));
    private Button btnMailUsername = new Button(By.xpath("//span[@id='inbox-id']"));
    private Button btnSetMailUsername = new Button(By.xpath("//span[@id='inbox-id']/button[text()='Set']"));
    private TextBox txtMailUsername = new TextBox(By.xpath("//span[@id='inbox-id']/input[@type='text']"));
    private ComboBox cbbMailDomain = new ComboBox(By.xpath("//select[@id='gm-host-select']"));


    public void uncheckScrambleAddressCheckbox() {
        chkScrambleAddress.uncheck();
    }

    public String getMail() {
        return tmpMail.getText();
    }

    public void clickConfirmLinkInMail() {
        mailConfirm.waitUntilElementVisible();
        mailConfirm.click();
        lnkConfirm.waitUntilElementVisible();
        lnkConfirm.click();
    }

    public void clickResetPasswordMail() {
        mailResetPassword.waitUntilElementVisible();
        mailResetPassword.click();
    }

    public void clickResetPasswordLinkInMail() {
        lnkResetPassword.waitUntilElementVisible();
        lnkResetPassword.click();
    }

    public void setMail(String mail) {
        String username = getMailUsername(mail);
        String domain = getMailDomain(mail);
        btnMailUsername.click();
        txtMailUsername.clear();
        txtMailUsername.enter(username);
        btnSetMailUsername.click();
        cbbMailDomain.select(domain);
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
        String[] parts = mailContent.getText().split("The token is: ");
        if (parts.length > 1) {
            String[] tokenParts = parts[1].split("\\.");
            return tokenParts[0].trim();
        }
        return "";
    }
}
