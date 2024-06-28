package com.nhantran.utils.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class ComboBox extends BaseControl {
    public ComboBox(By locator) {
        super(locator);
    }

    public void select(String text) {
        Select select = new Select(this.findElement());
        select.selectByVisibleText(text);
    }

    public String getSelectedOption() {
        Select select = new Select(this.findElement());
        return select.getFirstSelectedOption().getText();
    }
}
