package com.nhantran.pages;

import com.nhantran.models.Tickets;
import com.nhantran.utils.SeleniumActions;
import org.openqa.selenium.By;

public class MyTicketPage extends BasePage {

    private String btnCancelTicket = "//table[@class='MyTable']//tr[td[count(//tr/th[text()='Depart Station']/preceding-sibling::th)+1][text()='%s'] and " +
            "td[count(//tr/th[text()='Arrive Station']/preceding-sibling::th)+1][text()='%s'] and " +
            "td[count(//tr/th[text()='Seat Type']/preceding-sibling::th)+1][text()='%s'] and " +
            "td[count(//tr/th[text()='Depart Date']/preceding-sibling::th)+1][text()='%s'] and " +
            "td[count(//tr/th[text()='Amount']/preceding-sibling::th)+1][text()='%d']]" +
            "/td[count(//tr/th[text()='Operation']/preceding-sibling::th)+1]/input[@type='button']";

    public void cancelTicket(Tickets ticket) {
        SeleniumActions.clickElement(By.xpath(String.format(btnCancelTicket, ticket.getDepartStation().getValue(), ticket.getArrivalStation().getValue(), ticket.getSeatType().getValue(), ticket.getDepartDate(), ticket.getTicketAmount())));
    }
}
