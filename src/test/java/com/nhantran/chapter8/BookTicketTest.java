package com.nhantran.chapter8;

import com.nhantran.base.TestBase;
import com.nhantran.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookTicketTest extends TestBase {

    private static final String departDate = "6/20/2024";
    private static final String departStation = "Sài Gòn";
    private static final String arrivalStation = "Đà Nẵng";
    private static final String seatType = "Soft seat";
    private static final int ticketAmount = 2;

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    TimetablePage timetablePage = new TimetablePage();
    TicketPricePage ticketPricePage = new TicketPricePage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    BookTicketSuccessPage successPage = new BookTicketSuccessPage();

    @Test
    public void TC01_BookTicketAndCheckInfo() {
//        homePage.clickTab("Login");
//        loginPage.login(properties.getProperty("valid_username"), properties.getProperty("valid_password"));
//        homePage.clickTab("Timetable");
//        timetablePage.clickCheckPriceLink(departStation, arrivalStation);
//        ticketPricePage.clickBookTicketButton(seatType);
//
//        bookTicketPage.selectDepartDate(departDate);
//        bookTicketPage.selectAmount(ticketAmount);
//        bookTicketPage.clickBookTicketButton();
//
//        String successfulMessage = successPage.getSuccessfulMessage();
//        String ticketDepartStation = successPage.getDepartStation();
//        String ticketArrivalStation = successPage.getArrivalStation();
//        String ticketDepartDate = successPage.getDepartDate();
//        String ticketSeatType = successPage.getSeatType();
//        String ticketBookedAmount = successPage.getTicketAmount();
//
//        Assert.assertEquals(successfulMessage, "Ticket booked successfully!", "Successful message not matching");
//        Assert.assertEquals(ticketDepartStation, departStation, "Depart station not matching");
//        Assert.assertEquals(ticketArrivalStation, arrivalStation, "Arrival station not matching");
//        Assert.assertEquals(ticketDepartDate, departDate, "Depart date not matching");
//        Assert.assertEquals(ticketSeatType, seatType, "Seat type not matching");
//        Assert.assertEquals(ticketBookedAmount, String.valueOf(ticketAmount), "Ticket amount not matching");
    }

}
