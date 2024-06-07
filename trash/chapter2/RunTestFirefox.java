package com.nhantran.chapter2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RunTestFirefox {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.navigate().to("https://www.selenium.dev/documentation/");

        String webTitle = driver.getTitle();
        String expectedTitle = "The Selenium Browser Automation Project | Selenium";

        if (webTitle.equals(expectedTitle)){
            System.out.println("Title matched");
        } else {
            System.out.println("Title not matched");
        }

        driver.close();
    }
}
