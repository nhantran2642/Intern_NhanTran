package com.nhantran.utils.controls;

import com.nhantran.utils.drivers.DriverManager;
import org.openqa.selenium.WindowType;

import java.util.Set;

public class WindowControl {
    public static void refresh() {
        DriverManager.getDriver().navigate().refresh();
    }

    public static void openSiteInNewTab(String url) {
        DriverManager.getDriver().switchTo().newWindow(WindowType.TAB);
        DriverManager.getDriver().navigate().to(url);
    }

    public static void switchToWindow(String windowHandle) {
        DriverManager.getDriver().switchTo().window(windowHandle);
    }

    public static String getWindowHandle() {
        return DriverManager.getDriver().getWindowHandle();
    }

    public static void switchToRemainingTab(String windowHandleOfFirstTab, String windowHandleOfSecondTab) {
        Set<String> allTabs = DriverManager.getDriver().getWindowHandles();
        for (String tab : allTabs) {
            if (!tab.equals(windowHandleOfFirstTab) && !tab.equals(windowHandleOfSecondTab)) {
                DriverManager.getDriver().switchTo().window(tab);
                break;
            }
        }
    }
}
