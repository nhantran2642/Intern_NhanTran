package com.nhantran.pages;

import com.nhantran.utils.controls.Labels;
import org.openqa.selenium.By;


public class RegistrationConfirmationPage extends BasePage {

    private Labels lblConfirmSuccess = new Labels(By.xpath("//p"));

    public String getConfirmationSuccessMessage() {
        return lblConfirmSuccess.getText();
    }
}
