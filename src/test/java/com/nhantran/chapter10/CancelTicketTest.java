package com.nhantran.chapter10;

import com.nhantran.base.TestBase;
import com.nhantran.enums.RailwayStations;
import com.nhantran.enums.RailwayTabs;
import com.nhantran.enums.SeatTypes;
import com.nhantran.models.Ticket;
import com.nhantran.models.User;
import com.nhantran.pages.*;
import com.nhantran.utils.helpers.DateTimeHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CancelTicketTest extends TestBase {

    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();
    private BookTicketPage bookTicketPage = new BookTicketPage();
    private BookTicketSuccessPage bookTicketSuccessPage = new BookTicketSuccessPage();
    private MyTicketPage myTicketPage = new MyTicketPage();
    private User validUser = User.getLoginAccountFromJsonFile("validAccount");
    private Ticket ticket = new Ticket(DateTimeHelper.calculateNextDate(6), RailwayStations.DA_NANG, RailwayStations.NHA_TRANG, SeatTypes.SOFT_SEAT, 1);

    @Test(description = "User can cancel a ticket")
    public void TC016_CancelATicketSuccessfully() {
        homePage.clickTab(RailwayTabs.LOGIN);
        loginPage.login(validUser);
        homePage.clickTab(RailwayTabs.BOOK_TICKET);
        bookTicketPage.bookTicket(ticket);
        bookTicketSuccessPage.clickTab(RailwayTabs.MY_TICKET);
        myTicketPage.cancelTicket(ticket);
        myTicketPage.acceptToCancelTicket();
        Assert.assertFalse(myTicketPage.isCancelledTicketDisplayed(ticket), "Ticket still display");
    }
}
