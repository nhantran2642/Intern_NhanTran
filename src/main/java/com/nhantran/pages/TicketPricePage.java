package com.nhantran.pages;

import com.nhantran.enums.RailwayStations;
import com.nhantran.enums.SeatTypes;
import com.nhantran.utils.controls.Button;
import com.nhantran.utils.controls.Label;
import org.openqa.selenium.By;

public class TicketPricePage extends BasePage {

    private String dynLabelCheckPrice = "//th[li[contains(text(),'Trains depart from %s')]]/following::tr[td[contains(., '%s to %s')]]//a[text()='Check Price']";
    private String lblPriceOfSeatType = "//table[@class='MyTable MedTable']//th[normalize-space()='Price (VND)']//following-sibling::td[count(//td[text()='%s']/preceding-sibling::td)+1]";
    private String dynLabelBookTicket = "//td[text()='%s']//following-sibling::td//a[text()='Book ticket']";
    private Label lblPageTitle = new Label(By.xpath("//*[@id='content']//h1"));
    private Label lblTicketPriceTableHeader = new Label(By.xpath("//table[@class='MyTable MedTable']//tr[@class='TableSmallHeader']/th[contains(text(),'Ticket price from')]"));

    public boolean isPageTitleDisplayed(String title) {
        return lblPageTitle.isDisplayed();
    }

    public String getHeaderOfSeatPriceTable() {
        return lblTicketPriceTableHeader.getText();
    }

    public Integer getPriceOfSeatType(String seatType) {
        Label priceOfSeat = new Label(By.xpath(String.format(lblPriceOfSeatType, seatType)));
        return Integer.parseInt(priceOfSeat.getText());
    }

    public void clickCheckPriceButton(RailwayStations departStation, RailwayStations arriveStation) {
        Button btnCheckPrice = new Button(By.xpath(String.format(dynLabelCheckPrice, departStation.getValue(), departStation.getValue(), arriveStation.getValue())));
        btnCheckPrice.scrollIntoView();
        btnCheckPrice.click();
    }

    public void clickBookTicketButton(SeatTypes seatTypes){
        Button btnBookTicket = new Button(By.xpath(String.format(dynLabelBookTicket, seatTypes.getValue())));
        btnBookTicket.click();
    }
}
