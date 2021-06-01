package ui_tests;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DataTableDownloadPage;
import pages.DragDropSliderPage;
import pages.UI01_Page;
import utilities.Driver;
import utilities.ReusableMethods;

public class DragDropSlider_07_Test {

    UI01_Page page1;
    DragDropSliderPage dropSliderPage;
    DataTableDownloadPage dataTableDownload;
    WebDriverWait wait;
    Actions actions;

    {
        page1 = new UI01_Page();
        dropSliderPage = new DragDropSliderPage();
        dataTableDownload = new DataTableDownloadPage();
        wait = new WebDriverWait(Driver.getDriver(), 20);
        actions = new Actions(Driver.getDriver());
    }

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get("https://www.seleniumeasy.com/test/");

        try {
            page1.noThanksButton.click();
        } catch (Exception ignored) {

        }
        ReusableMethods.scrollToElement(dataTableDownload.advancedArrow);
        dataTableDownload.advancedArrow.click();
        dropSliderPage.dragDropSliderPageLink.click();
    }


    @Test
    public void TC_01() {
        dropSliderPage.setSlider(dropSliderPage.firstSlider10, dropSliderPage.firstOutput, 1);

        String actualResult = dropSliderPage.firstOutput.getText();
        String expectedResult = "1";
        Assert.assertEquals(actualResult,expectedResult);
    }


    @Test
    public void TC_02() {
        dropSliderPage.setSlider(dropSliderPage.sliders.get(1), dropSliderPage.outputs.get(1),33);

        String actualResult = dropSliderPage.outputs.get(1).getText();
        String expectedResult = "33";
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void TC_03() {
        dropSliderPage.setSlider(dropSliderPage.sliders.get(3),dropSliderPage.outputs.get(3),100);

        String actualResult = dropSliderPage.outputs.get(3).getText();
        String expectedResult = "100";
        Assert.assertEquals(actualResult,expectedResult);

    }


}
