package com.nhantran.pages;

import com.nhantran.utils.DriverManager;
import com.nhantran.utils.SeleniumActions;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class RegistrationConfirmationPage extends BasePage{

    By confirmSuccessMessage = By.xpath("//p");

    public String getConfirmationSuccessMessage(){
        return SeleniumActions.getElementText(confirmSuccessMessage);
    }
}
