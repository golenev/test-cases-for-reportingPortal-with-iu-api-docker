import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static utils.BrowserUtils.quitBrowser;
import static utils.BrowserUtils.setBrowser;

public abstract class BaseTest {

    @BeforeMethod
    public void setUp() {
        setBrowser();
    }

    @AfterMethod
    public void tearDown() {
        quitBrowser();
    }
}