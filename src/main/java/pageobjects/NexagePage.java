package pageobjects;

import aquality.selenium.core.elements.ElementState;
import aquality.selenium.core.elements.ElementsCount;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import enums.CellsIndexes;
import models.Tests;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class NexagePage extends Form {

    private static final String testList = "#test-list.";
    private static final String cellsLines = "//tbody/tr";
    private static final String uniqueCells = "//td";

    public List<Tests> getTestsListFromUi() {
        List<Tests> testsList = new ArrayList<>();
        List<IElement> rows = this.getElementFactory().findElements(By.xpath(cellsLines), ElementType.TEXTBOX,
                ElementsCount.MORE_THEN_ZERO, ElementState.EXISTS_IN_ANY_STATE);
        for (int i = CellsIndexes.INITIAL_TEST_VALUE.getIndex(); i < rows.size(); i++) {
            List<ITextBox> cells = rows.get(i).findChildElements(By.xpath(uniqueCells), ElementType.TEXTBOX);
            String name = cells.get(CellsIndexes.ZERO.getIndex()).getText();
            String method = cells.get(CellsIndexes.FIRST.getIndex()).getText();
            String status = cells.get(CellsIndexes.SECOND.getIndex()).getText().toUpperCase();
            String startTime = cells.get(CellsIndexes.THIRD.getIndex()).getText();
            String endTime = cells.get(CellsIndexes.FOURTH.getIndex()).getText();
            String duration = cells.get(CellsIndexes.FIFTH.getIndex()).getText();
            Tests tests = new Tests();
            tests.setName(name);
            tests.setMethod(method);
            tests.setStatus(status);
            tests.setStartTime(startTime);
            tests.setEndTime(endTime);
            tests.setDuration(duration);
            testsList.add(tests);
        }
        return testsList;
    }
    public NexagePage() {
        super(By.cssSelector(testList), "tests");
    }
}




