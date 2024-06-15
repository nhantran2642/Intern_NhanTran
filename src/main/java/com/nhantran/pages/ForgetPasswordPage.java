package com.nhantran.pages;

import com.nhantran.utils.SeleniumActions;
import org.openqa.selenium.By;

public class ForgetPasswordPage extends BasePage {
    private By txtEmail = By.xpath("//input[@id='email']");
    private By sendInstructionButton = By.xpath("//input[@type='submit']");


    public void getResetPasswordLink(String email) {
        SeleniumActions.enter(txtEmail, email);
        SeleniumActions.clickElement(sendInstructionButton);
    }
}
