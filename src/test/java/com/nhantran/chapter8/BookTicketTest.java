package com.nhantran.chapter8;

import com.nhantran.chapter8.base.TestBase;
import com.nhantran.pages.*;


public class BookTicketTest extends TestBase {

    private static final String testBrowser = "chrome";
    private static final String railwayUrl = "http://saferailway.somee.com/";
    private static final String username = "nhantran@grr.la";
    private static final String password = "1234567890";
    private static final String departDate = "6/20/2024";
    private static final String departStation = "Sài Gòn";
    private static final String arrivalStation = "Đà Nẵng";
    private static final String seatType = "Soft seat";
    private static final int ticketAmount = 2;

    public static void main(String[] args) {
        startAUT(testBrowser, railwayUrl);

        HomePage homePage = new HomePage();
        homePage.clickTab("Login");

        LoginPage loginPage = new LoginPage();
        homePage = loginPage.login(username, password);

        homePage.clickTab("Timetable");

        TimetablePage timetablePage = new TimetablePage();
        TicketPricePage ticketPricePage =  timetablePage.clickCheckPriceLink(departStation, arrivalStation);

        BookTicketPage bookTicketPage = ticketPricePage.clickBookTicketButton(seatType);

        bookTicketPage.selectDepartDate(departDate);
        bookTicketPage.selectAmount(ticketAmount);
        BookTicketSuccessPage successPage = bookTicketPage.clickBookTicketButton();

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
        ){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }
    }


}
