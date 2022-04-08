package utils;

import aquality.selenium.core.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static constants.ResourcesPath.CONFIG_PATH;
import static utils.TestingConfigurations.*;

import java.io.File;
import java.io.IOException;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public class ScreenShotUtils {
    public static void getScreenShot() {
        Logger.getInstance().info("creating screenshot");
        File scrFile = ((TakesScreenshot) getBrowser().getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(getDataFromResources(CONFIG_PATH, "/screenShotPath")));
        } catch (IOException e) {
            Logger.getInstance().info("Screenshot was not created");
            e.printStackTrace();
        }
    }

    public static File getScreenshotFile() {
        Logger.getInstance().info("getting screenshot");
        return new File(getDataFromResources(CONFIG_PATH, "/screenShotPath"));
    }

}
