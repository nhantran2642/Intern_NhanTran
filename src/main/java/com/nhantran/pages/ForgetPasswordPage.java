package com.nhantran.pages;

import com.nhantran.utils.controls.Button;
import com.nhantran.utils.controls.TextBox;
import org.openqa.selenium.By;

public class ForgetPasswordPage extends BasePage {
    private TextBox txtEmail = new TextBox(By.xpath("//input[@id='email']"));
    private Button btnSendInstruction = new Button(By.xpath("//input[@type='submit']"));

    public void submitPasswordResetInstructionsForm(String email) {
        txtEmail.enter(email);
        btnSendInstruction.click();
    }
}
