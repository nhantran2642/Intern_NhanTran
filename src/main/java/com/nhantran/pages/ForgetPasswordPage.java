package com.nhantran.pages;

import com.nhantran.utils.SeleniumActions;
import org.openqa.selenium.By;

public class ForgetPasswordPage extends BasePage {
    private By txtEmail = By.xpath("//input[@id='email']");
    private By btnSendInstruction = By.xpath("//input[@type='submit']");

    public void submitPasswordResetInstructionsForm(String email) {
        SeleniumActions.enter(txtEmail, email);
        SeleniumActions.clickElement(btnSendInstruction);
    }
}
