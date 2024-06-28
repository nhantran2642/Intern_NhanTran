package com.nhantran.utils.controls;

import org.openqa.selenium.By;

public class Link extends BaseControl {
    public Link(By locator) {
        super(locator);
    }

    public void click() {
        this.findElement().click();
    }
}
