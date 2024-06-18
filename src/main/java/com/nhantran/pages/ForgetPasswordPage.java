package com.nhantran.pages;

import com.nhantran.utils.actions.ButtonActions;
import com.nhantran.utils.actions.TextBoxActions;
import org.openqa.selenium.By;

public class ForgetPasswordPage extends BasePage {
    private By txtEmail = By.xpath("//input[@id='email']");
    private By btnSendInstruction = By.xpath("//input[@type='submit']");

    public void submitPasswordResetInstructionsForm(String email) {
        TextBoxActions.enter(txtEmail, email);
        ButtonActions.click(btnSendInstruction);
    }
}
