package com.nhantran.chapter5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DynamicLocateElements {

    private static final String railwayUrl = "http://saferailway.somee.com";
    private static final String validUsername = "nhantran@grr.la";
    private static final String validPassword = "1234567890";
    private static final String departStation = "Sài Gòn";
    private static final String arrivalStation = "Đà Nẵng";
    private static final String seatType = "Soft seat";
    private static final int numberOfNextDays = 7;
    private static final int ticketAmount = 2;

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(railwayUrl);

        // Dynamic Elements Xpath
        String railwayTab = "//div[@id='menu']//li/a/span[text()='%s']";
        String railwayButton = "//input[@value='%s']";
        String checkPriceLink = "//tr[td[text()='%s' and following-sibling::td[text()='%s']]]//a[text()='check price']";
        String bookTicketLink = "//tr[td[text()='%s']]//a[text()='Book ticket']";
        String railwaySelect = "//select[@name='%s']";
        String bookedTicketTableCell = "//td[count(//tr/th[text()='%s']/preceding-sibling::th)+1]";

        // Define specific elements base on dynamic xpath
        By tabLogin = By.xpath(String.format(railwayTab, "Login"));
        By tabTimetable = By.xpath(String.format(railwayTab, "Timetable"));
        By txtUsername = By.id("username");
        By txtPassword = By.id("password");
        By btnLogin = By.xpath(String.format(railwayButton, "login"));
        By linkCheckPriceSGDN = By.xpath(String.format(checkPriceLink, "Sài Gòn", "Đà Nẵng"));
        By btnSoftSeatBookTicket = By.xpath(String.format(bookTicketLink, "Soft seat"));
        By selectDepartDate = By.xpath(String.format(railwaySelect, "Date"));
        By selectTicketAmount = By.xpath(String.format(railwaySelect, "TicketAmount"));
        By btnBookTicket = By.xpath(String.format(railwayButton, "Book ticket"));
        By headerBookingSuccessfully = By.xpath("//h1");
        By tblDepartStation = By.xpath(String.format(bookedTicketTableCell, "Depart Station"));
        By tblArrivalStation = By.xpath(String.format(bookedTicketTableCell, "Arrive Station"));
        By tblSeatType = By.xpath(String.format(bookedTicketTableCell, "Seat Type"));
        By tblDepartDate = By.xpath(String.format(bookedTicketTableCell, "Depart Date"));
        By tblAmount = By.xpath(String.format(bookedTicketTableCell, "Amount"));

        // Step 1: Login Railway System with a valid account
        driver.findElement(tabLogin).click();
        driver.findElement(txtUsername).sendKeys(validUsername);
        driver.findElement(txtPassword).sendKeys(validPassword);
        driver.findElement(btnLogin).click();

        // Step 2: Click on Timetable tab
        driver.findElement(tabTimetable).click();

        // Step 3: Click on “check price” of Sai Gon-Da Nang
        driver.findElement(linkCheckPriceSGDN).click();

        // Step 4: Click on “book ticket” of “Soft seat”
        driver.findElement(btnSoftSeatBookTicket).click();

        // Step 5: Choose Depart date is next week (next 7 days) and Ticket amount is 2
            // Step 5.1: Get the next 7 days
        LocalDate currentDate = LocalDate.now();
        LocalDate nextDate = currentDate.plusDays(numberOfNextDays);
        String departDate = nextDate.format(DateTimeFormatter.ofPattern("M/d/yyyy"));

            // Step 5.2: Select the departure date is the geted date
        WebElement departDateDropdownList = driver.findElement(selectDepartDate);
        Select selectDate = new Select(departDateDropdownList);
        selectDate.selectByVisibleText(departDate);

            // Step 5.3: Select the ticket amount is 2
        WebElement ticketAmountDropdownList = driver.findElement(selectTicketAmount);
        Select selectAmount = new Select(ticketAmountDropdownList);
        selectAmount.selectByValue(String.valueOf(ticketAmount));

        // Step 6: Click on “book ticket”
        driver.findElement(btnBookTicket).click();

        // Expected: “Ticket booked successfully!” is shown with corrected ticket info
        String header = driver.findElement(headerBookingSuccessfully).getText();
        String ticketDepartStationInfo = driver.findElement(tblDepartStation).getText();
        String ticketArrivalStationInfo = driver.findElement(tblArrivalStation).getText();
        String ticketSeatTypeInfo = driver.findElement(tblSeatType).getText();
        String ticketDepartDateInfo = driver.findElement(tblDepartDate).getText();
        String ticketAmountInfo = driver.findElement(tblAmount).getText();

        if (header.equals("Ticket booked successfully!")
                && ticketDepartStationInfo.equals(departStation)
                && ticketArrivalStationInfo.equals(arrivalStation)
                && ticketSeatTypeInfo.equals(seatType)
                && ticketDepartDateInfo.equals(departDate)
                && ticketAmountInfo.equals(String.valueOf(ticketAmount))
        ) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        driver.quit();
    }

}



