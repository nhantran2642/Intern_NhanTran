package com.nhantran.pages;

import com.nhantran.utils.SeleniumActions;
import org.openqa.selenium.By;

public class TimetablePage extends BasePage {

    private String checkPriceLink = "//tr[td[text()='%s' and following-sibling::td[text()='%s']]]//a[text()='check price']";

    public void clickCheckPriceLink(String departStation, String arrivalStation) {
        SeleniumActions.clickElement(SeleniumActions.findElement(By.xpath(String.format(checkPriceLink, departStation, arrivalStation))));
    }
}
