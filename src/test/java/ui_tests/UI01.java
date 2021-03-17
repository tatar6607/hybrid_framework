package ui_tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.UI01_Page;
import utilities.Driver;

public class UI01 {

    UI01_Page ui01_page;
    Actions actions;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        String url = "https://www.seleniumeasy.com/test/";
        Driver.getDriver().get(url);

        ui01_page = new UI01_Page();
        actions = new Actions(Driver.getDriver());
        wait = new WebDriverWait(Driver.getDriver(), 10);

        wait.until(ExpectedConditions.elementToBeClickable(ui01_page.noThanksButton)).click();
        ui01_page.startButton.click();

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ui01_page.allLinks.get(0).click(); // Click simple form demo link
    }

    @Test
    public void UI01() {
        String message = "Hello World";
        ui01_page.messageInput.sendKeys(message);
        ui01_page.showMessageButton.click();
        System.out.println("Tc01 message = " + ui01_page.messageText.getText());

        Assert.assertTrue(ui01_page.messageText.isDisplayed());
        Assert.assertTrue(ui01_page.messageText.getText().equals(message));
    }

    @Test
    public void UI02() {
        String [] alphabet = {"a", "b"};
        String [] numbers = {"3","5"};

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        ui01_page.inputA.sendKeys(alphabet[0]);
        ui01_page.inputB.sendKeys(alphabet[1]);
        ui01_page.getTotalButton.click();

        Assert.assertTrue(ui01_page.getResultText.getText().equals("NaN"));

        Driver.getDriver().navigate().refresh();

        ui01_page.inputA.sendKeys(numbers[0]);
        ui01_page.inputB.sendKeys(numbers[1]);
        ui01_page.getTotalButton.click();

        String sum  = (Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1])) +"";
        Assert.assertEquals(ui01_page.getResultText.getText() , sum );

    }

    @AfterClass
    public void tearDown() {
        Driver.closeDriver();
    }
}
