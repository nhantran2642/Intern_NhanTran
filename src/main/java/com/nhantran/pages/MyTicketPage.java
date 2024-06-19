package com.nhantran.pages;

import com.nhantran.models.Tickets;
import com.nhantran.utils.controls.Alerts;
import com.nhantran.utils.controls.Buttons;
import com.nhantran.utils.controls.Labels;
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
        Buttons btnCancelTicket = new Buttons(By.xpath(String.format(dynButtonCancelTicket, ticket.getDepartStation().getValue(), ticket.getArrivalStation().getValue(), ticket.getSeatType().getValue(), ticket.getDepartDate(), ticket.getTicketAmount())));
        btnCancelTicket.click();
    }

    public void acceptToCancelTicket() {
        Alerts alert = new Alerts();
        alert.acceptAlert();
    }

    public boolean isCancelledTicketDisplayed(Tickets ticket) {
        Labels tkRow = new Labels(By.xpath(String.format(dynTicketRow, ticket.getDepartStation().getValue(), ticket.getArrivalStation().getValue(), ticket.getSeatType().getValue(), ticket.getDepartDate(), ticket.getTicketAmount())));
        return tkRow.isDisplayed();

    }
}
