package com.nhantran.pages;

import com.nhantran.enums.RailwayStations;
import com.nhantran.utils.SeleniumActions;
import org.openqa.selenium.By;

public class TimetablePage extends BasePage {

    private String lnkCheckPrice = "//tr[td[text()='%s' and following-sibling::td[text()='%s']]]//a[text()='check price']";
    private String lnkBookTicket = "//tr[td[text()='%s' and following-sibling::td[text()='%s']]]//a[text()='book ticket']";

    public void clickCheckPriceLink(RailwayStations departStation, RailwayStations arrivalStation) {
        SeleniumActions.scrollToElement((By.xpath(String.format(lnkCheckPrice, departStation.getValue(), arrivalStation.getValue()))));
        SeleniumActions.clickElement((By.xpath(String.format(lnkCheckPrice, departStation.getValue(), arrivalStation.getValue()))));
    }

    public void clickBookTicketLink(RailwayStations departStation, RailwayStations arrivalStation) {
        SeleniumActions.scrollToElement((By.xpath(String.format(lnkBookTicket, departStation.getValue(), arrivalStation.getValue()))));
        SeleniumActions.clickElement((By.xpath(String.format(lnkBookTicket, departStation.getValue(), arrivalStation.getValue()))));
    }

}
