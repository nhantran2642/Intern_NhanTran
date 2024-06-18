package com.nhantran.utils.actions;

import org.openqa.selenium.By;

public class TextBoxActions extends BaseActions {
    public static void enter(By element, String text) {
        findElement(element).sendKeys(text);
    }

    public static void clear(By element) {
        findElement(element).clear();
    }

}
