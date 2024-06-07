package com.nhantran.chapter8;

import com.nhantran.base.TestBase;
import com.nhantran.pages.*;


public class BookTicketTest extends TestBase {

    private static final String username = "nhantran@grr.la";
    private static final String password = "1234567890";
    private static final String departDate = "6/20/2024";
    private static final String departStation = "Sài Gòn";
    private static final String arrivalStation = "Đà Nẵng";
    private static final String seatType = "Soft seat";
    private static final int ticketAmount = 2;

    public static void main(String[] args) {
        startAUT();

        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        TimetablePage timetablePage = new TimetablePage();
        TicketPricePage ticketPricePage = new TicketPricePage();
        BookTicketPage bookTicketPage = new BookTicketPage();
        BookTicketSuccessPage successPage = new BookTicketSuccessPage();

        homePage.clickTab("Login");
        loginPage.login(username, password);
        homePage.clickTab("Timetable");
        timetablePage.clickCheckPriceLink(departStation, arrivalStation);
        ticketPricePage.clickBookTicketButton(seatType);

        bookTicketPage.selectDepartDate(departDate);
        bookTicketPage.selectAmount(ticketAmount);
        bookTicketPage.clickBookTicketButton();

        String successfulMessage = successPage.getSuccessfulMessage();
        String ticketDepartStation = successPage.getDepartStation();
        String ticketArrivalStation = successPage.getArrivalStation();
        String ticketDepartDate = successPage.getDepartDate();
        String ticketSeatType = successPage.getSeatType();
        String ticketBookedAmount = successPage.getTicketAmount();

        if (successfulMessage.equals("Ticket booked successfully!")
                && ticketDepartStation.equals(departStation)
                && ticketArrivalStation.equals(arrivalStation)
                && ticketDepartDate.equals(departDate)
                && ticketSeatType.equals(seatType)
                && ticketBookedAmount.equals(String.valueOf(ticketAmount))
        ) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
    }


}
