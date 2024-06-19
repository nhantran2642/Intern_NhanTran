package com.nhantran.utils.controls;

import org.openqa.selenium.By;

public class Button extends BaseControl {

    public Button(By locator) {
        super(locator);
    }

    public void click() {
        this.findElement().click();
    }
}
