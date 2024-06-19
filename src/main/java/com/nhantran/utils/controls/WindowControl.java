package com.nhantran.utils.controls;

import com.nhantran.utils.DriverManager;
import org.openqa.selenium.WindowType;

import java.util.Set;

public class WindowControl {
    public static void refresh() {
        DriverManager.driver.navigate().refresh();
    }

    public static void openSiteInNewTab(String url) {
        DriverManager.driver.switchTo().newWindow(WindowType.TAB);
        DriverManager.driver.navigate().to(url);
    }

    public static void switchToWindow(String windowHandle) {
        DriverManager.driver.switchTo().window(windowHandle);
    }

    public static String getWindowHandle() {
        return DriverManager.driver.getWindowHandle();
    }

    public static void switchToRemainingTab(String windowHandleOfFirstTab, String windowHandleOfSecondTab) {
        Set<String> allTabs = DriverManager.driver.getWindowHandles();
        for (String tab : allTabs) {
            if (!tab.equals(windowHandleOfFirstTab) && !tab.equals(windowHandleOfSecondTab)) {
                DriverManager.driver.switchTo().window(tab);
                break;
            }
        }
    }
}
