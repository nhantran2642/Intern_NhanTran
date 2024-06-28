package com.nhantran.finaltest;

import com.nhantran.base.TestBase;
import com.nhantran.enums.RailwayStations;
import com.nhantran.enums.RailwayTabs;
import com.nhantran.enums.SeatTypes;
import com.nhantran.models.Ticket;
import com.nhantran.models.User;
import com.nhantran.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FTTC703_BookTicketWithKnownPrice extends TestBase {

    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();
    private TicketPricePage ticketPricePage = new TicketPricePage();
    private BookTicketPage bookTicketPage = new BookTicketPage();
    private BookTicketSuccessPage bookTicketSuccessPage = new BookTicketSuccessPage();
    private User validUser = User.getLoginAccountFromJsonFile("validAccount");

    @Test(description = "User can book ticket from Ticket price with known price")
    public void FTTC703() {
        Ticket ticket = new Ticket(null, 2);
        homePage.clickTab(RailwayTabs.LOGIN);
        loginPage.login(validUser);
        homePage.clickTab(RailwayTabs.TICKET_PRICE);
        ticketPricePage.clickCheckPriceButton(RailwayStations.HUE, RailwayStations.QUANG_NGAI);
        Integer priceOfSeat = ticketPricePage.getPriceOfSeatType("HS");
        ticketPricePage.clickBookTicketButton(SeatTypes.HARD_SEAT);
        bookTicketPage.bookTicket(ticket);
        Assert.assertEquals(bookTicketSuccessPage.getTicketTotalPrice(), priceOfSeat * ticket.getTicketAmount(), "Total price incorrectly");
    }
}
