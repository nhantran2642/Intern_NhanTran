package com.nhantran.pages;

import com.nhantran.utils.controls.Label;
import org.openqa.selenium.By;


public class RegistrationConfirmationPage extends BasePage {

    private Label lblConfirmSuccess = new Label(By.xpath("//p"));

    public String getConfirmationSuccessMessage() {
        return lblConfirmSuccess.getText();
    }
}
