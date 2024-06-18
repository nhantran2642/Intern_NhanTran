package com.nhantran.chapter10;

import com.nhantran.base.TestBase;
import com.nhantran.enums.RailwayStations;
import com.nhantran.enums.RailwayTabs;
import com.nhantran.enums.SeatTypes;
import com.nhantran.models.Tickets;
import com.nhantran.models.User;
import com.nhantran.pages.*;
import com.nhantran.utils.Constants;
import com.nhantran.utils.DateTimeHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CancelTicketTest extends TestBase {

    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();
    private BookTicketPage bookTicketPage = new BookTicketPage();
    private BookTicketSuccessPage bookTicketSuccessPage = new BookTicketSuccessPage();
    private MyTicketPage myTicketPage = new MyTicketPage();
    private User validUser = new User(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);
    private Tickets ticket = new Tickets(DateTimeHelper.calculateNextDate(6), RailwayStations.DA_NANG, RailwayStations.NHA_TRANG, SeatTypes.SOFT_SEAT, 1);

    @Test(description = "User can cancel a ticket")
    public void TC016_CancelATicketSuccessfully() {
        homePage.clickTab(RailwayTabs.LOGIN);
        loginPage.login(validUser);
        homePage.clickTab(RailwayTabs.BOOK_TICKET);
        bookTicketPage.bookTicket(ticket);
        bookTicketSuccessPage.clickTab(RailwayTabs.MY_TICKET);
        myTicketPage.cancelTicket(ticket);
        myTicketPage.acceptCancelTicket();
        Assert.assertFalse(myTicketPage.isCancelledTicketDisplayed(ticket), "Ticket still display");
    }
}
