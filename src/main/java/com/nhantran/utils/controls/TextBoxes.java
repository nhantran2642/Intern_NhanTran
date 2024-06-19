package com.nhantran.utils.controls;

import org.openqa.selenium.By;

public class TextBoxes extends BaseControl {
    public TextBoxes(By locator) {
        super(locator);
    }

    public void enter(String text) {
        this.findElement().sendKeys(text);
    }

    public void clear() {
        this.findElement().clear();
    }
}
