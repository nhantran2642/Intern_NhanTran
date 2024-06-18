package com.nhantran.utils.actions;

import com.nhantran.utils.DriverManager;

public class AlertActions {
    public static void acceptAlert() {
        DriverManager.driver.switchTo().alert().accept();
    }
}
