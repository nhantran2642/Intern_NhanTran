package com.nhantran.pages;

import com.nhantran.models.Tickets;
import com.nhantran.utils.actions.AlertActions;
import com.nhantran.utils.actions.BaseActions;
import com.nhantran.utils.actions.ButtonActions;
import org.openqa.selenium.By;

public class MyTicketPage extends BasePage {

    private String dynButtonCancelTicket = "//table[@class='MyTable']//tr[" +
            "td[count(//tr/th[text()='Depart Station']/preceding-sibling::th)+1][text()='%s'] and " +
            "td[count(//tr/th[text()='Arrive Station']/preceding-sibling::th)+1][text()='%s'] and " +
            "td[count(//tr/th[text()='Seat Type']/preceding-sibling::th)+1][text()='%s'] and " +
            "td[count(//tr/th[text()='Depart Date']/preceding-sibling::th)+1][text()='%s'] and " +
            "td[count(//tr/th[text()='Amount']/preceding-sibling::th)+1][text()='%d']" +
            "]/td[count(//tr/th[text()='Operation']/preceding-sibling::th)+1]/input[@type='button' and @value='Cancel']";

    private String dynTicketRow = "//table[@class='MyTable']//tr[" +
            "td[count(//tr/th[text()='Depart Station']/preceding-sibling::th)+1][text()='%s'] and " +
            "td[count(//tr/th[text()='Arrive Station']/preceding-sibling::th)+1][text()='%s'] and " +
            "td[count(//tr/th[text()='Seat Type']/preceding-sibling::th)+1][text()='%s'] and " +
            "td[count(//tr/th[text()='Depart Date']/preceding-sibling::th)+1][text()='%s'] and " +
            "td[count(//tr/th[text()='Amount']/preceding-sibling::th)+1][text()='%d']]";


    public void cancelTicket(Tickets ticket) {
        By btnCancelTicket = By.xpath(String.format(dynButtonCancelTicket, ticket.getDepartStation().getValue(), ticket.getArrivalStation().getValue(), ticket.getSeatType().getValue(), ticket.getDepartDate(), ticket.getTicketAmount()));
        ButtonActions.click(btnCancelTicket);
    }

    public void acceptCancelTicket() {
        AlertActions.acceptAlert();
    }

    public boolean isCancelledTicketDisplayed(Tickets ticket) {
        By ticketRow = By.xpath(String.format(dynTicketRow, ticket.getDepartStation().getValue(), ticket.getArrivalStation().getValue(), ticket.getSeatType().getValue(), ticket.getDepartDate(), ticket.getTicketAmount()));
        return BaseActions.isElementDisplayed(ticketRow);
    }
}
