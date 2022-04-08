package pageobjects;

import aquality.selenium.core.elements.ElementState;
import aquality.selenium.core.elements.ElementsCount;
import aquality.selenium.core.logging.Logger;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.util.List;

import static aquality.selenium.browser.AqualityServices.getElementFactory;
import static java.lang.String.format;

public class MainPageDB extends Form {

    private IButton nexageProjectBtn = getElementFactory().getButton(By.xpath("//a[normalize-space()='Nexage']"), "Nexage project button");
    private ILabel createdTestInstance = getElementFactory().getLabel(By.xpath("//a[contains(text(),'%s')]"), "dynamic locator by created test item");
    private static final String uniqueElement = ".panel-heading";
    private static final String patternProjectLocator = "//a[contains(text(),'%s')]";

    public MainPageDB() {
        super(By.cssSelector(uniqueElement), "posts on the wall");
    }

    public void selectTable() {
        nexageProjectBtn.clickAndWait();
    }
    public Boolean isTestAppeared(String createdProject) {
        String locator = String.format(patternProjectLocator, createdProject);
        return getElementFactory().getLabel(By.xpath(locator), "New random project").state().isDisplayed();
    }

}
