package com.nhantran.pages;

import com.nhantran.utils.DriverManager;
import com.nhantran.utils.SeleniumActions;
import org.openqa.selenium.By;

public class BookTicketPage extends BasePage {
    private String selectBox = "//select[@name='%s']";
    private String bookTicketButton = "//input[@value='Book ticket']";

    private void selectBookTicketInfo(String comboBoxName, String value) {
        By bookTicketSelectBox = By.xpath(String.format(selectBox, comboBoxName));
        SeleniumActions.selectByText(bookTicketSelectBox, value);
    }

    public void selectDepartDate(String date) {
        this.selectBookTicketInfo("Date", date);
    }

    public void selectDepartStation(String departStation) {
        this.selectBookTicketInfo("DepartStation", departStation);
    }

    public void selectArrivalStation(String arrivalStation) {
        this.selectBookTicketInfo("ArriveStation", arrivalStation);
    }

    public void selectSeatType(String seatType) {
        this.selectBookTicketInfo("SeatType", seatType);
    }

    public void selectAmount(Integer amount) {
        this.selectBookTicketInfo("TicketAmount", String.valueOf(amount));
    }

    public void clickBookTicketButton() {
        SeleniumActions.clickElement(By.xpath(bookTicketButton));
    }


}
