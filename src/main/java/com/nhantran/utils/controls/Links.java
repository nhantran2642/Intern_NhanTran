package com.nhantran.utils.controls;

import org.openqa.selenium.By;

public class Links extends BaseControl {
    public Links(By locator) {
        super(locator);
    }

    public void click() {
        this.findElement().click();
    }
}
