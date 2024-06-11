package com.nhantran.pages;

import com.nhantran.utils.SeleniumActions;
import org.openqa.selenium.By;

public class ForgetPasswordPage extends BasePage {
    By txtEmail = By.xpath("//input[@id='email']");
    By sendInstructionButton = By.xpath("//input[@type='submit']");


    public void getResetPasswordLink(String email) {
        SeleniumActions.sendKeysToElement(txtEmail, email);
        SeleniumActions.clickElement(sendInstructionButton);
    }
}
