package com.nhantran.chapter3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class LocateWebElement {

    private static final String password = "1234567890";
    private static final String pid = "0987654321";
    private static final String railwayUrl = "http://saferailway.somee.com";
    private static final String guerrillamailUrl = "https://www.guerrillamail.com/inbox";

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // navigate to mail website
        driver.navigate().to(guerrillamailUrl);
        String mailPage = driver.getWindowHandle();
        // select the mail host
        WebElement hostMailSelect = driver.findElement(By.xpath("//*[@id='gm-host-select']"));
        Select select = new Select(hostMailSelect);
        select.selectByValue("grr.la");
        // uncheck the scramble address checkbox
        WebElement scrambleAddressCheckbox = driver.findElement(By.xpath("//*[@id='use-alias']"));
        scrambleAddressCheckbox.click();
        //copy the email
        WebElement emailBox = driver.findElement(By.xpath("//*[@id='email-widget']"));
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
        // paste the copied email to the email textbox
        WebElement emailTextBox = driver.findElement(By.xpath("//*[@id='email']"));
        emailTextBox.click();
        a.keyDown(Keys.CONTROL);
        a.sendKeys("v");
        a.keyUp(Keys.CONTROL);
        a.build().perform();
        //enter password
        WebElement passwordTextBox = driver.findElement(By.xpath("//*[@id='password']"));
        passwordTextBox.sendKeys(password);
        //confirm password
        WebElement confirmPasswordTextBox = driver.findElement(By.xpath("//*[@id='confirmPassword']"));
        confirmPasswordTextBox.sendKeys(password);
        // enter PID
        WebElement pidTextBox = driver.findElement(By.xpath("//*[@id='pid']"));
        pidTextBox.sendKeys(pid);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)", "");
        //click Register button
        WebElement registerButton = driver.findElement(By.xpath("//*[@id='RegisterForm']//p/input[@type='submit']"));
        registerButton.click();
        String railwayPage = driver.getWindowHandle();
        // re-navigate to mail page
        driver.switchTo().window(mailPage);
        //if ads display, click button close
//        if(driver.findElement(By.xpath("//div[@id='card']")).isDisplayed()){
//            driver.findElement(By.xpath("//div[@id='card']//div[@id='dismiss-button']")).click();
//        }
        //confirm email
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='email_table']//tr[contains(@class, 'mail')]//td[contains(.,'Please confirm your account')]")));
        //click confirm email
        WebElement txtEmailConfirm = driver.findElement(By.xpath("//table[@id='email_table']//tr[contains(@class, 'mail')]//td[contains(.,'Please confirm your account')]"));
        txtEmailConfirm.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='display_email']//a[contains(@href,'Confirm')]")));

        WebElement txtLinkConfirm = driver.findElement(By.xpath("//*[@id='display_email']//a[contains(@href,'confirmationCode')]"));
        txtLinkConfirm.click();

        driver.switchTo().window(railwayPage);

        WebElement loginTab = driver.findElement(By.xpath("//div[@id='menu']//li/a[span[text()='Login']]"));
        loginTab.click();

        WebElement loginEmailTxt = driver.findElement(By.xpath("//input[@id='username']"));
        emailTextBox.click();
        a.keyDown(Keys.CONTROL);
        a.sendKeys("v");
        a.keyUp(Keys.CONTROL);
        a.build().perform();
        //enter password
        WebElement loginPasswordTxt = driver.findElement(By.xpath("//input[@id='password']"));
        passwordTextBox.sendKeys(password);

        WebElement loginButton = driver.findElement(By.xpath("//*[@class='LoginForm']//p/input[@type='submit']"));
        loginButton.click();

        WebElement bookTicketTab = driver.findElement(By.xpath("//div[@id='menu']//li/a[span[text()='Book ticket']]"));
        bookTicketTab.click();

        driver.close();
    }
}
