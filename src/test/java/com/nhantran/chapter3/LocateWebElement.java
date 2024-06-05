package com.nhantran.chapter3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LocateWebElement {

    private static final String password = "0000000000";
    private static final String pid = "0987654321";
    private static final String railwayUrl = "http://saferailway.somee.com";
    private static final String mailUrl = "https://www.guerrillamail.com/inbox";
    private static final int ticketAmount = 2;

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // navigate to mail website
        driver.navigate().to(mailUrl);
        String mailPage = driver.getWindowHandle();

        WebElement hostMailSelect = driver.findElement(By.xpath("//*[@id='gm-host-select']"));
        WebElement scrambleAddressCheckbox = driver.findElement(By.xpath("//*[@id='use-alias']"));
        WebElement emailBox = driver.findElement(By.xpath("//*[@id='email-widget']"));

        // select the mail host
        Select select = new Select(hostMailSelect);
        select.selectByValue("grr.la");
        // uncheck the scramble address checkbox
        scrambleAddressCheckbox.click();
        //copy the email
        emailBox.click();
        Actions a = new Actions(driver);
        a.keyDown(Keys.CONTROL);
        a.sendKeys("c");
        a.keyUp(Keys.CONTROL);
        a.build().perform();

        //navigate to railway in new tab
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to(railwayUrl);

        //move to Register tab
        WebElement registerTab = driver.findElement(By.xpath("//div[@id='menu']//li/a[span[text()='Register']]"));
        registerTab.click();

        WebElement emailTextBox = driver.findElement(By.xpath("//*[@id='email']"));
        WebElement passwordTextBox = driver.findElement(By.xpath("//*[@id='password']"));
        WebElement confirmPasswordTextBox = driver.findElement(By.xpath("//*[@id='confirmPassword']"));
        WebElement pidTextBox = driver.findElement(By.xpath("//*[@id='pid']"));
        WebElement registerButton = driver.findElement(By.xpath("//*[@id='RegisterForm']//p/input[@type='submit']"));

        // paste the copied email to the email textbox
        emailTextBox.click();
        a.keyDown(Keys.CONTROL);
        a.sendKeys("v");
        a.keyUp(Keys.CONTROL);
        a.build().perform();
        //enter password
        passwordTextBox.sendKeys(password);
        //confirm password
        confirmPasswordTextBox.sendKeys(password);
        // enter PID
        pidTextBox.sendKeys(pid);
        // scroll down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)", "");
        //click Register button
        registerButton.click();
        String railwayPage = driver.getWindowHandle();

        // re-navigate to mail page
        driver.switchTo().window(mailPage);

        //confirm email
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='email_table']//tr[contains(@class, 'mail')]//td[contains(.,'Please confirm your account')]")));
        //click confirm email
        WebElement txtEmailConfirm = driver.findElement(By.xpath("//table[@id='email_table']//tr[contains(@class, 'mail')]//td[contains(.,'Please confirm your account')]"));
        txtEmailConfirm.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='display_email']//a[contains(@href,'Confirm')]")));
        //click confirm link
        WebElement txtLinkConfirm = driver.findElement(By.xpath("//*[@id='display_email']//a[contains(@href,'confirmationCode')]"));
        txtLinkConfirm.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //re-navigate to railway
        driver.switchTo().window(railwayPage);

        WebElement loginTab = driver.findElement(By.xpath("//*[@id='menu']//a[span[text()='Login']]"));
        loginTab.click();

        WebElement loginEmailTxt = driver.findElement(By.xpath("//*[@id='username']"));
        WebElement loginPasswordTxt = driver.findElement(By.xpath("//*[@id='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//*[@class='LoginForm']//p/input[@type='submit']"));
        loginEmailTxt.click();
        a.keyDown(Keys.CONTROL);
        a.sendKeys("v");
        a.keyUp(Keys.CONTROL);
        a.build().perform();
        //enter password
        loginPasswordTxt.sendKeys(password);
        //click login button
        loginButton.click();

        // move to book ticket tab
        WebElement bookTicketTab = driver.findElement(By.xpath("//div[@id='menu']//li/a[span[text()='Book ticket']]"));
        bookTicketTab.click();

        //scroll down
        js.executeScript("window.scrollBy(0,300)", "");

        WebElement ticketAmountSelect = driver.findElement(By.xpath("//*[@name='TicketAmount']"));
        Select ticketSelect = new Select(ticketAmountSelect);
        ticketSelect.selectByValue(String.valueOf(ticketAmount));

        //click book ticket button
        WebElement bookTicketButton = driver.findElement(By.xpath("//fieldset/input[@type='submit']"));
        bookTicketButton.click();

        driver.quit();
    }
}
