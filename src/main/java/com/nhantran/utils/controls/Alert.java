package com.nhantran.utils.controls;

import com.nhantran.utils.drivers.DriverManager;

public class Alert {
    public void acceptAlert() {
        DriverManager.getDriver().switchTo().alert().accept();
    }
}
