package com.nhantran.pages;

import com.nhantran.utils.controls.Labels;
import org.openqa.selenium.By;

public class TicketPricePage extends BasePage {

    private String lblPriceOfSeatType = "//table[@class='MyTable MedTable']//th[normalize-space()='Price (VND)']//following-sibling::td[count(//td[text()='%s']/preceding-sibling::td)+1]";
    private Labels lblPageTitle = new Labels(By.xpath("//*[@id='content']//h1"));
    private Labels lblTicketPriceTableHeader = new Labels(By.xpath("//table[@class='MyTable MedTable']//tr[@class='TableSmallHeader']/th[contains(text(),'Ticket price from')]"));

    public boolean isPageTitleDisplayed(String title) {
        return lblPageTitle.isDisplayed();
    }

    public String getHeaderOfSeatPriceTable() {
        return lblTicketPriceTableHeader.getText();
    }

    public Integer getPriceOfSeatType(String seatType) {
        Labels priceOfSeat = new Labels(By.xpath(String.format(lblPriceOfSeatType, seatType)));
        return Integer.parseInt(priceOfSeat.getText());
    }
}
