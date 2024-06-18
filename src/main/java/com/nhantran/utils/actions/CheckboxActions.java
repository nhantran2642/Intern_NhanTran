package com.nhantran.utils.actions;

import org.openqa.selenium.By;

public class CheckboxActions extends BaseActions{
    public static void check(By element) {
        if (!findElement(element).isSelected())
            findElement(element).click();
    }

    public static void uncheck(By element) {
        if (findElement(element).isSelected())
            findElement(element).click();
    }
}
