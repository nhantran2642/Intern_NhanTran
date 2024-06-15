package com.nhantran.pages;

import com.nhantran.enums.RailwayStations;
import com.nhantran.enums.SeatTypes;
import com.nhantran.utils.SeleniumActions;
import org.openqa.selenium.By;

public class TicketPricePage extends BasePage {

    private String bookTicketButton = "//tr[td[text()='%s']]//a[text()='Book ticket']";
    private String lblPriceOfSeatType = "//table[@class='MyTable MedTable']//th[normalize-space()='Price (VND)']//following-sibling::td[count(//td[text()='%s']/preceding-sibling::td)+1]";
    private By lblPageTitle = By.xpath("//*[@id='content']//h1");
    private By lblTicketPriceTableHeader = By.xpath("//table[@class='MyTable MedTable']//tr[@class='TableSmallHeader']/th[contains(text(),'Ticket price from')]");

    public void clickBookTicketButton(SeatTypes seatType) {
        SeleniumActions.clickElement(By.xpath(String.format(bookTicketButton, seatType.getValue())));
    }

    public boolean isPageTitleDisplayed(String title) {
        return SeleniumActions.findElement(lblPageTitle).isDisplayed();
    }


    public String getHeaderOfSeatPriceTable(){
        return SeleniumActions.getElementText(lblTicketPriceTableHeader);
    }

    public Integer getPriceOfSeatType(String seatType){
        return Integer.parseInt(SeleniumActions.getElementText(By.xpath(String.format(lblPriceOfSeatType, seatType))));
    }
}
