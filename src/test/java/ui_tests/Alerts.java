package ui_tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.AlertsPage;
import pages.UI01_Page;
import utilities.Driver;

public class Alerts {

    UI01_Page page1 = new UI01_Page();
    AlertsPage alertsPage = new AlertsPage();

    @BeforeClass
    public void setUp() {
        Driver.getDriver().get("https://www.seleniumeasy.com/test/");
        page1.noThanksButton.click();
        page1.startButton.click();
        alertsPage.alertPageLink.click();


    }

    @Test
    public void alert_01() {
        alertsPage.clickMeButtons.get(0).click();
        String actualAlertText = Driver.getDriver().switchTo().alert().getText();
        Driver.getDriver().switchTo().alert().accept();
        String expectedAlertText = "I am an alert box!";

        Assert.assertEquals(actualAlertText, expectedAlertText);
    }

    @Test
    public void alert_02() {
        alertsPage.clickMeButtons.get(1).click();
        Driver.getDriver().switchTo().alert().dismiss();
        String actualAlertMassage = alertsPage.alertMassage.getText();
        String expectedMassage = "You pressed Cancel!";

        Assert.assertEquals(actualAlertMassage, expectedMassage);
    }

    @Test
    public void alert_03() {
        alertsPage.clickMeButton3.click();
        String text = "Ali";
        Driver.getDriver().switchTo().alert().sendKeys(text);
        Driver.getDriver().switchTo().alert().accept();
        String textMassage = alertsPage.sendKeyMassage.getText();
        Assert.assertTrue(textMassage.contains(text));

    }

    @AfterClass
    public void tearDown() {
        Driver.closeDriver();
    }
}
