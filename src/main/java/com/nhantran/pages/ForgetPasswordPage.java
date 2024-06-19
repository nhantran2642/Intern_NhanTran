package com.nhantran.pages;

import com.nhantran.utils.controls.Buttons;
import com.nhantran.utils.controls.TextBoxes;
import org.openqa.selenium.By;

public class ForgetPasswordPage extends BasePage {
    private TextBoxes txtEmail = new TextBoxes(By.xpath("//input[@id='email']"));
    private Buttons btnSendInstruction = new Buttons(By.xpath("//input[@type='submit']"));

    public void submitPasswordResetInstructionsForm(String email) {
        txtEmail.enter(email);
        btnSendInstruction.click();
    }
}
