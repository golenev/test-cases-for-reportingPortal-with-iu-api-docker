package utils;

import aquality.selenium.browser.AqualityServices;
import org.openqa.selenium.Cookie;

public class CookiesUtils {

    public void addCookie(Cookie cookie) {
        AqualityServices.getLogger().info(String.format("Adding %s cookie", cookie.getName()));
        AqualityServices.getBrowser().getDriver().manage().addCookie(cookie);
    }
}
