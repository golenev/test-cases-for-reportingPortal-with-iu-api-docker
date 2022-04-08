package pageobjects;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class ProjectCreationForm extends Form {

    private final ITextBox enterProjectName = getElementFactory().getTextBox(By.xpath("//input[@id='projectName']"), "project name field");
    private final IButton saveProjectBtn = getElementFactory().getButton(
            By.xpath("//button[@type='submit']"), "Save project");
    private final ILabel alertSuccess = getElementFactory().getLabel(
            By.xpath("//div[contains(@class,'alert-success')]"), "Success");
    private static final String addProject = "//div[@class='modal-header']";

    public ProjectCreationForm() {
        super(By.xpath(addProject), "Add project");
    }

    public void sendProjectName(String projectName) {
        enterProjectName.sendKeys(projectName);
    }

    public void clickSaveProject() {
        saveProjectBtn.click();
    }

    public Boolean isProjectCreated() {
        return alertSuccess.state().isDisplayed();
    }
}

