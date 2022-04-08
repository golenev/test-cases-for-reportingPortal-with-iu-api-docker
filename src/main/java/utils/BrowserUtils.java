package utils;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;

import java.util.Set;

import static aquality.selenium.browser.AqualityServices.getBrowser;
import static constants.ResourcesPath.CONFIG_PATH;
import static utils.TestingConfigurations.getDataFromResources;

public class BrowserUtils {

    private static Browser browser = AqualityServices.getBrowser();

    public static void setBrowser() {
        browser.maximize();
    }

    public static void quitBrowser() {
        browser.quit();
    }

    public static void navigateBack() {
        getBrowser().getDriver().navigate().back();
    }

    public static void reloadPage() {
        getBrowser().getDriver().navigate().refresh();
    }

    public static String getWindowHandle() {
        return getBrowser().getDriver().getWindowHandle();
    }

    public static void prepareBrowser() {
        browser = getBrowser();
        browser.goTo(getDataFromResources(CONFIG_PATH, "/url"));
    }

    public static String switchWindowHandle(String windowHandle) {
        Set<String> handles = getBrowser().getDriver().getWindowHandles();
        String newHandle = null;
        for (String handle : handles) {
            if (!windowHandle.equals(handle)) {
                newHandle = handle;
                getBrowser().getDriver().switchTo().window(handle);
            }
        }
        return newHandle;
    }
}
