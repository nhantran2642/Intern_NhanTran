package com.nhantran.pages;

import com.nhantran.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage extends BasePage{
    private final static String selectBox = "//select[@name='%s']";
    private final static String bookTicketButton = "//input[@value='Book ticket']";

    public void selectDepartDate(String date) {
        By departDateSelectBox = By.xpath(String.format(selectBox, "Date"));
        Select select = new Select(DriverManager.driver.findElement(departDateSelectBox));
        select.selectByVisibleText(date);
    }

    public void selectDepartStation(String departStation) {
        By departStationSelectBox = By.xpath(String.format(selectBox, "DepartStation"));
        Select select = new Select(DriverManager.driver.findElement(departStationSelectBox));
        select.selectByVisibleText(departStation);
    }

    public void selectArrivalStation(String arrivalStation) {
        By arrivalStationSelectBox = By.xpath(String.format(selectBox, "ArriveStation"));
        Select select = new Select(DriverManager.driver.findElement(arrivalStationSelectBox));
        select.selectByVisibleText(arrivalStation);
    }

    public void selectSeatType(String seatType) {
        By seatTypeSelectBox = By.xpath(String.format(selectBox, "SeatType"));
        Select select = new Select(DriverManager.driver.findElement(seatTypeSelectBox));
        select.selectByVisibleText(seatType);
    }

    public void selectAmount(Integer amount) {
        By amountSelectBox = By.xpath(String.format(selectBox, "TicketAmount"));
        Select select = new Select(DriverManager.driver.findElement(amountSelectBox));
        select.selectByVisibleText(String.valueOf(amount));
    }

    public BookTicketSuccessPage clickBookTicketButton(){
        DriverManager.driver.findElement(By.xpath(bookTicketButton)).click();

        return new BookTicketSuccessPage();
    }

}
