package com.nhantran.finaltest;

import com.nhantran.base.TestBase;
import com.nhantran.common.Constants;
import com.nhantran.enums.RailwayStations;
import com.nhantran.enums.RailwayTabs;
import com.nhantran.enums.SeatTypes;
import com.nhantran.enums.Status;
import com.nhantran.models.Ticket;
import com.nhantran.models.User;
import com.nhantran.pages.*;
import com.nhantran.utils.controls.WindowControl;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FTTC702_FilterTableWithBothDepartDateAndArriveStation extends TestBase {
    private HomePage homePage = new HomePage();
    private RegisterPage registerPage = new RegisterPage();
    private LoginPage loginPage = new LoginPage();
    private MailboxPage mailboxPage = new MailboxPage();
    private RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage();
    private BookTicketPage bookTicketPage = new BookTicketPage();
    private BookTicketSuccessPage bookTicketSuccessPage = new BookTicketSuccessPage();
    private MyTicketPage myTicketPage = new MyTicketPage();

    private User newUser = new User(null, "1234567890", "1234567890", "11111111111");

    private List<Ticket> listOf6DifferentTickets = Ticket.generateTicketsWithDifferentDepartDate(6, RailwayStations.DA_NANG, RailwayStations.HUE, SeatTypes.HARD_SEAT, 1);
    private Ticket ticketToFilter = listOf6DifferentTickets.get(2);

    @BeforeMethod(dependsOnMethods = "setUp")
    public void createSuccessfullyANewAccountAndLoginCreatedAccount() {
        homePage.goToRegisterPage();
        String railwayWindow = WindowControl.getWindowHandle();
        WindowControl.openSiteInNewTab(Constants.TEMPORARY_MAIL_URL);
        newUser.setEmail(mailboxPage.getMail());
        String mailWindow = WindowControl.getWindowHandle();
        WindowControl.switchToWindow(railwayWindow);
        registerPage.register(newUser);
        WindowControl.switchToWindow(mailWindow);
        WindowControl.refresh();
        mailboxPage.clickConfirmLinkInMail();
        WindowControl.switchToRemainingTab(railwayWindow, mailWindow);
        registrationConfirmationPage.clickTab(RailwayTabs.LOGIN);
        loginPage.login(new User(newUser.getEmail(), newUser.getPassword()));
    }

    @Test(description = "User can filter Manage ticket table with both depart date and arrive station")
    public void FTTC702() {
        homePage.clickTab(RailwayTabs.BOOK_TICKET);
        bookTicketsWithDifferentDepartDate();
        bookTicketPage.clickTab(RailwayTabs.MY_TICKET);
        myTicketPage.filter(null, ticketToFilter.getArrivalStation(), ticketToFilter.getDepartDate(), null);
        Assert.assertTrue(myTicketPage.isFilteredTicketDisplayed(ticketToFilter, Status.NEW), "The filtered ticket does not display");
    }

    private void bookTicketsWithDifferentDepartDate() {
        for (Ticket ticket : listOf6DifferentTickets) {
            bookTicketPage.bookTicket(ticket);
            bookTicketSuccessPage.clickTab(RailwayTabs.BOOK_TICKET);
        }
    }
}
