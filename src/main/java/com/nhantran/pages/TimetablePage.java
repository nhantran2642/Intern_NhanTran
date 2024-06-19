package com.nhantran.pages;

import com.nhantran.enums.RailwayStations;
import com.nhantran.utils.controls.Link;
import org.openqa.selenium.By;

public class TimetablePage extends BasePage {

    private String dynLinkCheckPrice = "//tr[td[text()='%s' and following-sibling::td[text()='%s']]]//a[text()='check price']";
    private String dynLinkBookTicket = "//tr[td[text()='%s' and following-sibling::td[text()='%s']]]//a[text()='book ticket']";

    public void clickCheckPriceLink(RailwayStations departStation, RailwayStations arrivalStation) {
        clickLink(dynLinkCheckPrice, departStation, arrivalStation);
    }

    public void clickBookTicketLink(RailwayStations departStation, RailwayStations arrivalStation) {
        clickLink(dynLinkBookTicket, departStation, arrivalStation);
    }

    private void clickLink(String dynamicLinkType, RailwayStations departStation, RailwayStations arrivalStation) {
        Link genericLink = new Link(By.xpath(String.format(dynamicLinkType, departStation.getValue(), arrivalStation.getValue())));
        genericLink.scrollIntoView();
        genericLink.click();
    }
}
