package com.nhantran.chapter10;

import com.nhantran.base.TestBase;
import com.nhantran.common.Constants;
import com.nhantran.common.Messages;
import com.nhantran.enums.BookTicketComboBoxes;
import com.nhantran.enums.RailwayStations;
import com.nhantran.enums.RailwayTabs;
import com.nhantran.enums.SeatTypes;
import com.nhantran.models.Ticket;
import com.nhantran.models.User;
import com.nhantran.pages.*;
import com.nhantran.utils.controls.WindowControl;
import com.nhantran.utils.helpers.DateTimeHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class E2ETest extends TestBase {

    private HomePage homePage = new HomePage();
    private RegisterPage registerPage = new RegisterPage();
    private LoginPage loginPage = new LoginPage();
    private MailboxPage mailboxPage = new MailboxPage();
    private RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage();
    private TimetablePage timetablePage = new TimetablePage();
    private BookTicketPage bookTicketPage = new BookTicketPage();
    private BookTicketSuccessPage bookTicketSuccessPage = new BookTicketSuccessPage();
    private MyTicketPage myTicketPage = new MyTicketPage();

    private User newUser = new User(null, "1234567890", "1234567890", "11111111111");
    private Ticket ticket = new Ticket(DateTimeHelper.calculateNextDate(10), RailwayStations.DA_NANG, RailwayStations.HUE, SeatTypes.HARD_SEAT, 1);

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
        Assert.assertEquals(registrationConfirmationPage.getConfirmationSuccessMessage(), Messages.MSG_SUCCESS_CONFIRM_REGISTRATION, "The registration confirmation message does not match");
        registrationConfirmationPage.clickTab(RailwayTabs.LOGIN);
        loginPage.login(new User(newUser.getEmail(), newUser.getPassword()));
    }

    @Test(description = "User can successfully create and confirm a new account, then login, book a new ticket, cancel a booked ticket and logout")
    public void E2ETestFromCreatingAccountToBookingTicketThenCancelingTicketAndLoggingOut() {
        homePage.clickTab(RailwayTabs.TIMETABLE);
        timetablePage.clickBookTicketLink(ticket.getDepartStation(), ticket.getArrivalStation());
        Assert.assertEquals(bookTicketPage.getStation(BookTicketComboBoxes.DEPART_STATION), ticket.getDepartStation().getValue(), "Depart station does not match");
        Assert.assertEquals(bookTicketPage.getStation(BookTicketComboBoxes.ARRIVE_STATION), ticket.getArrivalStation().getValue(), "Arrive station does not match");
        bookTicketPage.bookTicket(ticket);
        Assert.assertTrue(bookTicketSuccessPage.isSuccessfulMessageDisplayed("Ticket booked successfully!"), "Success message does not show");
        bookTicketSuccessPage.clickTab(RailwayTabs.MY_TICKET);
        myTicketPage.cancelTicket(ticket);
        myTicketPage.acceptToCancelTicket();
        myTicketPage.clickTab(RailwayTabs.LOG_OUT);
        Assert.assertTrue(homePage.isHomePageTitleDisplayed());
        Assert.assertFalse(homePage.isTabDisplayed(RailwayTabs.LOG_OUT));
    }
}
