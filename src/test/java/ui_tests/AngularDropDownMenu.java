package ui_tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AngularDDMPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class AngularDropDownMenu {


    AngularDDMPage angularPage;
    String url;

    @BeforeClass
    public void setUp() {
        angularPage = new AngularDDMPage();
        url = "https://material.angular.io/components/select/overview";

        Driver.getDriver().get(url);
    }

    @Test
    public void firstAngularDropDownTest() {
        ReusableMethods.scrollToElement(angularPage.firstDropDownMenu);
        angularPage.clickFirstDropDownMenu();

        ReusableMethods.waitForAttributeToBe(angularPage.firstDropDownAllElements.get(0), "aria-disabled", "false");
        angularPage.firstDropDownAllElements.get(0).click();

        String expectedResult = "Steak";
        String actualResult = angularPage.firstDropDownSelectedElement.getText();

        System.out.println("actualResult = " + actualResult);
        Assert.assertEquals(actualResult,expectedResult);
    }
}
