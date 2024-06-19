package com.nhantran.utils.controls;

import com.nhantran.utils.DriverManager;

public class Alerts {
    public void acceptAlert() {
        DriverManager.driver.switchTo().alert().accept();
    }
}
