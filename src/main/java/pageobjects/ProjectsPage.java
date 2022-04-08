package pageobjects;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import static java.lang.String.format;

public class ProjectsPage extends Form {

    private IButton addButton = getElementFactory().getButton(By.xpath("//a[@href='addProject']"), "Add button");
    private static final String variantNumber = "//span[text()='Version: %s']";
    private static final String listGroup = "//div[@class='list-group']";

    public ProjectsPage() {
        super(By.xpath(listGroup), "unique element Projects");
    }

    public void clickAddButton() {
        addButton.click();
    }

    public Boolean isVariantCorrect(String variant) {
        String xpath = String.format(variantNumber, variant);
        return getElementFactory().getLabel(By.xpath(xpath), "Variant number").state().isDisplayed();
    }

}
