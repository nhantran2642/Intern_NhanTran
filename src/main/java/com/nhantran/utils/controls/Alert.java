package com.nhantran.utils.controls;

import com.nhantran.utils.DriverManager;

public class Alert {
    public void acceptAlert() {
        DriverManager.driver.switchTo().alert().accept();
    }
}
