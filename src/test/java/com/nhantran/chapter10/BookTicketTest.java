package com.nhantran.chapter10;

import com.nhantran.base.TestBase;
import com.nhantran.enums.BookTicketComboBoxes;
import com.nhantran.enums.RailwayStations;
import com.nhantran.enums.RailwayTabs;
import com.nhantran.enums.SeatTypes;
import com.nhantran.models.Tickets;
import com.nhantran.models.User;
import com.nhantran.pages.*;
import com.nhantran.utils.Constants;
import com.nhantran.utils.DateTimeHelper;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BookTicketTest extends TestBase {

    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();
    private TimetablePage timetablePage = new TimetablePage();
    private TicketPricePage ticketPricePage = new TicketPricePage();
    private BookTicketPage bookTicketPage = new BookTicketPage();
    private BookTicketSuccessPage bookTicketSuccessPage = new BookTicketSuccessPage();
    private User validUser = new User(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

    @DataProvider(name = "bookTicketData")
    public Object[][] dataTestTC012AndTC013() {
        return new Object[][]{
                {new Tickets(DateTimeHelper.calculateNextDate(12), RailwayStations.NHA_TRANG, RailwayStations.HUE, SeatTypes.SOFT_BED_AIR_CONDITIONER, 1)},
                {new Tickets(DateTimeHelper.calculateNextDate(25), RailwayStations.NHA_TRANG, RailwayStations.DA_NANG, SeatTypes.SOFT_SEAT_AIR_CONDITIONER, 5)}
        };
    }

    @Test(dataProvider = "bookTicketData", description = "User can book 1 ticket or many tickets at a time")
    public void TC012_013_BookSuccessfullyATicketAndManyTickets(Tickets ticket) {
        homePage.clickTab(RailwayTabs.LOGIN);
        loginPage.login(validUser);
        homePage.clickTab(RailwayTabs.BOOK_TICKET);
        bookTicketPage.bookTicket(ticket);
        Assert.assertTrue(bookTicketSuccessPage.isSuccessfulMessageDisplayed("Ticket booked successfully!"), "Success message does not show");
        Assert.assertEquals(bookTicketSuccessPage.getDepartDate(), ticket.getDepartDate(), "Depart date not matching");
        Assert.assertEquals(bookTicketSuccessPage.getDepartStation(), ticket.getDepartStation().getValue(), "Depart station not matching");
        Assert.assertEquals(bookTicketSuccessPage.getArrivalStation(), ticket.getArrivalStation().getValue(), "Arrival station not matching");
        Assert.assertEquals(bookTicketSuccessPage.getSeatType(), ticket.getSeatType().getValue(), "Seat type not matching");
        Assert.assertEquals(bookTicketSuccessPage.getTicketAmount(), ticket.getTicketAmount(), "Ticket amount not matching");
    }

    @Test(description = "User can check price of ticket from Timetable")
    public void TC014_CheckTicketPriceFromTimetable() {
        homePage.clickTab(RailwayTabs.LOGIN);
        loginPage.login(validUser);
        homePage.clickTab(RailwayTabs.TIMETABLE);
        timetablePage.clickCheckPriceLink(RailwayStations.DA_NANG, RailwayStations.SAI_GON);
        Assert.assertTrue(ticketPricePage.isPageTitleDisplayed("Ticket Price"), "Page does not load");
        Assert.assertEquals(ticketPricePage.getHeaderOfSeatPriceTable(), "Ticket price from Đà Nẵng to Sài Gòn", "Wrong ticket");
        Assert.assertEquals(ticketPricePage.getPriceOfSeatType("HS"), 310000, "Price of Hard seat is wrong");
        Assert.assertEquals(ticketPricePage.getPriceOfSeatType("SS"), 335000, "Price of Soft seat is wrong");
        Assert.assertEquals(ticketPricePage.getPriceOfSeatType("SSC"), 360000, "Price of Soft seat with air conditioner is wrong");
        Assert.assertEquals(ticketPricePage.getPriceOfSeatType("HB"), 410000, "Price of Hard bed is wrong");
        Assert.assertEquals(ticketPricePage.getPriceOfSeatType("SB"), 460000, "Price of Soft bed is wrong");
        Assert.assertEquals(ticketPricePage.getPriceOfSeatType("SBC"), 510000, "Price of Soft bed with air conditioner is wrong");
    }

    @Test(description = "User can book ticket from Timetable")
    public void TC015_BookSuccessfullyTicketFromTimetable() {
        Tickets ticket = new Tickets(DateTimeHelper.calculateNextDate(10), SeatTypes.HARD_SEAT, 5);
        homePage.clickTab(RailwayTabs.LOGIN);
        loginPage.login(validUser);
        homePage.clickTab(RailwayTabs.TIMETABLE);
        timetablePage.clickBookTicketLink(RailwayStations.QUANG_NGAI, RailwayStations.HUE);
        Assert.assertEquals(bookTicketPage.getStation(BookTicketComboBoxes.DEPART_STATION), RailwayStations.QUANG_NGAI.getValue(), "Depart station does not match");
        Assert.assertEquals(bookTicketPage.getStation(BookTicketComboBoxes.ARRIVE_STATION), RailwayStations.HUE.getValue(), "Arrive station does not match");
        bookTicketPage.bookTicket(ticket);
        Assert.assertTrue(bookTicketSuccessPage.isSuccessfulMessageDisplayed("Ticket booked successfully!"), "Success message does not show");
        Assert.assertEquals(bookTicketSuccessPage.getDepartDate(), ticket.getDepartDate(), "Depart date not matching");
        Assert.assertEquals(bookTicketSuccessPage.getDepartStation(), RailwayStations.QUANG_NGAI.getValue(), "Depart station not matching");
        Assert.assertEquals(bookTicketSuccessPage.getArrivalStation(), RailwayStations.HUE.getValue(), "Arrival station not matching");
        Assert.assertEquals(bookTicketSuccessPage.getSeatType(), ticket.getSeatType().getValue(), "Seat type not matching");
        Assert.assertEquals(bookTicketSuccessPage.getTicketAmount(), ticket.getTicketAmount(), "Ticket amount not matching");
    }


}
