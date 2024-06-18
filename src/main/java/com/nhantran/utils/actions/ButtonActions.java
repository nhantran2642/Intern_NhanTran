package com.nhantran.utils.actions;

import org.openqa.selenium.By;

public class ButtonActions extends BaseActions{
    public static void click(By element) {
        findElement(element).click();
    }
}
