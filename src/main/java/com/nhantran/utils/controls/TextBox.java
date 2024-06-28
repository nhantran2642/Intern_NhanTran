package com.nhantran.utils.controls;

import org.openqa.selenium.By;

public class TextBox extends BaseControl {
    public TextBox(By locator) {
        super(locator);
    }

    public void enter(String text) {
        this.findElement().sendKeys(text);
    }

    public void clear() {
        this.findElement().clear();
    }
}
