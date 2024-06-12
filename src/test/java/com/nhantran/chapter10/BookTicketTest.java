package com.nhantran.chapter10;

import com.nhantran.base.TestBase;
import com.nhantran.enums.BookTicketComboBoxes;
import com.nhantran.enums.RailwayStations;
import com.nhantran.enums.RailwayTabs;
import com.nhantran.enums.SeatTypes;
import com.nhantran.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BookTicketTest extends TestBase {

    public BookTicketTest() {
        super();
    }

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    TimetablePage timetablePage = new TimetablePage();
    TicketPricePage ticketPricePage = new TicketPricePage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    BookTicketSuccessPage bookTicketSuccessPage = new BookTicketSuccessPage();

    @Test
    public void TC012_SuccessToBookATicket() {
        int numberOfNextDays = 12;
        int ticketAmount = 1;
        homePage.clickTab(RailwayTabs.LOGIN);
        loginPage.login(validUsername, validPassword);
        homePage.clickTab(RailwayTabs.BOOK_TICKET);
        bookTicketPage.bookTicket(calculateNextDate(numberOfNextDays),
                RailwayStations.NHA_TRANG,
                RailwayStations.HUE,
                SeatTypes.SOFT_BED_AIR_CONDITIONER,
                ticketAmount);
        Assert.assertEquals(bookTicketSuccessPage.isSuccessfulMessageDisplayed("Ticket booked successfully!"), Boolean.TRUE, "Success message does not show");
        Assert.assertEquals(bookTicketSuccessPage.getDepartDate(), calculateNextDate(numberOfNextDays), "Depart date not matching");
        Assert.assertEquals(bookTicketSuccessPage.getDepartStation(), RailwayStations.NHA_TRANG.getValue(), "Depart station not matching");
        Assert.assertEquals(bookTicketSuccessPage.getArrivalStation(), RailwayStations.HUE.getValue(), "Arrival station not matching");
        Assert.assertEquals(bookTicketSuccessPage.getSeatType(), SeatTypes.SOFT_BED_AIR_CONDITIONER.getValue(), "Seat type not matching");
        Assert.assertEquals(bookTicketSuccessPage.getTicketAmount(), String.valueOf(ticketAmount), "Ticket amount not matching");
    }

    @Test
    public void TC013_SuccessToBookManyTickets() {
        int numberOfNextDays = 25;
        int ticketAmount = 5;
        homePage.clickTab(RailwayTabs.LOGIN);
        loginPage.login(validUsername, validPassword);
        homePage.clickTab(RailwayTabs.BOOK_TICKET);
        bookTicketPage.bookTicket(calculateNextDate(numberOfNextDays), RailwayStations.NHA_TRANG, RailwayStations.SAI_GON, SeatTypes.SOFT_SEAT_AIR_CONDITIONER, ticketAmount);
        Assert.assertEquals(bookTicketSuccessPage.isSuccessfulMessageDisplayed("Ticket booked successfully!"), Boolean.TRUE, "Success message does not show");
        Assert.assertEquals(bookTicketSuccessPage.getDepartDate(), calculateNextDate(numberOfNextDays), "Depart date not matching");
        Assert.assertEquals(bookTicketSuccessPage.getDepartStation(), RailwayStations.NHA_TRANG.getValue(), "Depart station not matching");
        Assert.assertEquals(bookTicketSuccessPage.getArrivalStation(), RailwayStations.HUE.getValue(), "Arrival station not matching");
        Assert.assertEquals(bookTicketSuccessPage.getSeatType(), SeatTypes.SOFT_BED_AIR_CONDITIONER.getValue(), "Seat type not matching");
        Assert.assertEquals(bookTicketSuccessPage.getTicketAmount(), String.valueOf(ticketAmount), "Ticket amount not matching");
    }

    @Test
    public void TC014_SuccessToCheckTicketPriceFromTimetable() {
        homePage.clickTab(RailwayTabs.LOGIN);
        loginPage.login(validUsername, validPassword);
        homePage.clickTab(RailwayTabs.TIMETABLE);
        timetablePage.clickCheckPriceLink(RailwayStations.DA_NANG, RailwayStations.SAI_GON);
        Assert.assertEquals(ticketPricePage.isPageTitleDisplayed("Ticket Price"), Boolean.TRUE, "Page does not load");
        Assert.assertEquals(ticketPricePage.getHeaderOfSeatPriceTable(), "Ticket price from Đà Nẵng to Sài Gòn", "Wrong ticket");
        Assert.assertEquals(ticketPricePage.getPriceOfSeatType("HS"), 310000, "Price of Hard seat is wrong");
        Assert.assertEquals(ticketPricePage.getPriceOfSeatType("SS"), 335000, "Price of Soft seat is wrong");
        Assert.assertEquals(ticketPricePage.getPriceOfSeatType("SSC"), 360000, "Price of Soft seat with air conditioner is wrong");
        Assert.assertEquals(ticketPricePage.getPriceOfSeatType("HB"), 410000, "Price of Hard bed is wrong");
        Assert.assertEquals(ticketPricePage.getPriceOfSeatType("SB"), 460000, "Price of Soft bed is wrong");
        Assert.assertEquals(ticketPricePage.getPriceOfSeatType("SBC"), 510000, "Price of Soft bed with air conditioner is wrong");
    }

    @Test
    public void TC015_SuccessToBookTicketFromTimetable() {
        int numberOfNextDays = 10;
        int ticketAmount = 5;
        String departDate = calculateNextDate(numberOfNextDays);
        homePage.clickTab(RailwayTabs.LOGIN);
        loginPage.login(validUsername, validPassword);
        homePage.clickTab(RailwayTabs.TIMETABLE);
        timetablePage.clickBookTicketLink(RailwayStations.QUANG_NGAI, RailwayStations.HUE);
        Assert.assertEquals(bookTicketPage.getStation(BookTicketComboBoxes.DEPART_STATION), RailwayStations.QUANG_NGAI.getValue(), "Depart station does not match");
        Assert.assertEquals(bookTicketPage.getStation(BookTicketComboBoxes.ARRIVE_STATION), RailwayStations.HUE.getValue(), "Arrive station does not match");
        bookTicketPage.bookTicket(departDate, null, null, SeatTypes.HARD_SEAT, ticketAmount);
        Assert.assertEquals(bookTicketSuccessPage.isSuccessfulMessageDisplayed("Ticket booked successfully!"), Boolean.TRUE, "Success message does not show");
        Assert.assertEquals(bookTicketSuccessPage.getDepartDate(), departDate, "Depart date not matching");
        Assert.assertEquals(bookTicketSuccessPage.getDepartStation(), RailwayStations.QUANG_NGAI.getValue(), "Depart station not matching");
        Assert.assertEquals(bookTicketSuccessPage.getArrivalStation(), RailwayStations.HUE.getValue(), "Arrival station not matching");
        Assert.assertEquals(bookTicketSuccessPage.getSeatType(), SeatTypes.HARD_SEAT.getValue(), "Seat type not matching");
        Assert.assertEquals(bookTicketSuccessPage.getTicketAmount(), String.valueOf(ticketAmount), "Ticket amount not matching");
    }

    private String calculateNextDate(int numberOfNextDays) {
        LocalDate currentDate = LocalDate.now();
        LocalDate nextDate = currentDate.plusDays(numberOfNextDays);
        return nextDate.format(DateTimeFormatter.ofPattern("M/d/yyyy"));
    }
}
