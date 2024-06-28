package com.nhantran.utils.controls;

import org.openqa.selenium.By;

public class CheckBox extends BaseControl {
    public CheckBox(By locator) {
        super(locator);
    }

    public void check() {
        if (!this.findElement().isSelected())
            this.findElement().click();
    }

    public void uncheck() {
        if (this.findElement().isSelected())
            this.findElement().click();
    }
}
