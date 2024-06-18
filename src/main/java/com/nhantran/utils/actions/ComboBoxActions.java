package com.nhantran.utils.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class ComboBoxActions extends BaseActions {
    public static void select(By element, String text) {
        Select select = new Select(findElement(element));
        select.selectByVisibleText(text);
    }

    public static String getSelectedOption(By element) {
        Select select = new Select(findElement(element));
        return select.getFirstSelectedOption().getText();
    }
}
