package com.nhantran.pages;

import com.nhantran.utils.actions.BaseActions;
import org.openqa.selenium.By;


public class RegistrationConfirmationPage extends BasePage {

    private By lblConfirmSuccess = By.xpath("//p");

    public String getConfirmationSuccessMessage() {
        return BaseActions.getElementText(lblConfirmSuccess);
    }
}
