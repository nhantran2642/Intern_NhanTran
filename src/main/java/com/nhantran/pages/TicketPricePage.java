package com.nhantran.pages;

import com.nhantran.enums.SeatTypes;
import com.nhantran.utils.actions.BaseActions;
import com.nhantran.utils.actions.ButtonActions;
import org.openqa.selenium.By;

public class TicketPricePage extends BasePage {

    private String btnBookTicket = "//tr[td[text()='%s']]//a[text()='Book ticket']";
    private String lblPriceOfSeatType = "//table[@class='MyTable MedTable']//th[normalize-space()='Price (VND)']//following-sibling::td[count(//td[text()='%s']/preceding-sibling::td)+1]";
    private By lblPageTitle = By.xpath("//*[@id='content']//h1");
    private By lblTicketPriceTableHeader = By.xpath("//table[@class='MyTable MedTable']//tr[@class='TableSmallHeader']/th[contains(text(),'Ticket price from')]");

    public void clickBookTicketButton(SeatTypes seatType) {
        ButtonActions.click(By.xpath(String.format(btnBookTicket, seatType.getValue())));
    }

    public boolean isPageTitleDisplayed(String title) {
        return BaseActions.isElementDisplayed(lblPageTitle);
    }

    public String getHeaderOfSeatPriceTable() {
        return BaseActions.getElementText(lblTicketPriceTableHeader);
    }

    public Integer getPriceOfSeatType(String seatType) {
        By priceOfSeat = By.xpath(String.format(lblPriceOfSeatType, seatType));
        return Integer.parseInt(BaseActions.getElementText(priceOfSeat));
    }
}
