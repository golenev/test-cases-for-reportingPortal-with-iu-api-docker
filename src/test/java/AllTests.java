import api.ApiMethods;
import aquality.selenium.core.logging.Logger;
import models.Tests;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.MainPageDB;
import pageobjects.NexagePage;
import pageobjects.ProjectCreationForm;
import pageobjects.ProjectsPage;
import utils.BrowserUtils;
import utils.CookiesUtils;
import utils.ScreenShotUtils;

import static api.ApiMethods.getTestListFromApi;
import static constants.ResourcesPath.TESTING_PATH;
import static utils.RandomGenerator.*;

import java.util.*;

import static api.ApiMethods.createNewTestWithLogsAndAttachment;
import static aquality.selenium.browser.AqualityServices.getBrowser;
import static utils.BrowserUtils.*;
import static utils.TestingConfigurations.*;

public class AllTests extends BaseTest {

    private MainPageDB mainPageDB = new MainPageDB();
    private CookiesUtils cookiesUtils = new CookiesUtils();
    private NexagePage nexagePage = new NexagePage();
    private ProjectsPage projectsPage = new ProjectsPage();
    private ProjectCreationForm projectCreationForm = new ProjectCreationForm();

    @Test
    public void adwTest(){
        System.out.println(getTestListFromApi());
    }

    @Test
    public void firstCase() {
        prepareBrowser();
        String token = ApiMethods.getKey();
        cookiesUtils.addCookie(new Cookie(getDataFromResources(TESTING_PATH, "/cookieType"), token));
        getBrowser().getDriver().navigate().refresh();
        Assert.assertTrue(projectsPage.state().waitForDisplayed(), "Sorry, unique element is not available");
        Assert.assertTrue(projectsPage.isVariantCorrect(getDataFromResources(TESTING_PATH, "/variant")), "Variant is incorrect.");
        mainPageDB.selectTable();
        List<Tests> testsFromApi = ApiMethods.getTestListFromApi();
        List<Tests> testsFromUi = nexagePage.getTestsListFromUi();
        Assert.assertTrue(testsFromUi.stream().allMatch(testsFromApi::contains), "does not match");
        Logger.getInstance().info("checking the occurrence of a subset is successful");
        Logger.getInstance().info("Starting the fourth step");
        BrowserUtils.navigateBack();
        String currentHandle = getWindowHandle();
        projectsPage.clickAddButton();
        switchWindowHandle(currentHandle);
        Logger.getInstance().info("random value is " + randomProjectName);
        projectCreationForm.sendProjectName(randomProjectName);
        projectCreationForm.clickSaveProject();
        Assert.assertTrue(projectCreationForm.isProjectCreated(), "Project was not created");
        String popUpHandle = getWindowHandle();
        switchWindowHandle(popUpHandle);
        reloadPage();
        Logger.getInstance().info("page is refreshed");
        ScreenShotUtils.getScreenShot();
        Logger.getInstance().info("screenshot is done");
        createNewTestWithLogsAndAttachment(faker.commerce().material(), faker.company().name(), faker.job().field(), faker.code().isbnRegistrant());
        Logger.getInstance().info("log and attachment were made");
        Assert.assertTrue(mainPageDB.isTestAppeared(randomProjectName), "New test was not appeared.");
        Logger.getInstance().info("the assert was successful");
    }

}
