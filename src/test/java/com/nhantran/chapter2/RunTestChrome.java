package com.nhantran.chapter2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RunTestChrome {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.navigate().to("https://www.selenium.dev/documentation/");
        String webTitle = driver.getTitle();
        String expectedTitle = "The Selenium Browser Automation Project | Selenium";
        if (webTitle.equals(expectedTitle))
            System.out.println("Title Matched");
        else
            System.out.println("Title didn't match");
        driver.close();
    }
}
