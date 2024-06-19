package com.nhantran.utils.controls;

import org.openqa.selenium.By;

public class Buttons extends BaseControl {

    public Buttons(By locator) {
        super(locator);
    }

    public void click() {
        this.findElement().click();
    }
}
