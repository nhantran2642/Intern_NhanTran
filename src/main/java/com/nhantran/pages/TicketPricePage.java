package com.nhantran.pages;

import com.nhantran.utils.controls.Label;
import org.openqa.selenium.By;

public class TicketPricePage extends BasePage {

    private String lblPriceOfSeatType = "//table[@class='MyTable MedTable']//th[normalize-space()='Price (VND)']//following-sibling::td[count(//td[text()='%s']/preceding-sibling::td)+1]";
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
}
