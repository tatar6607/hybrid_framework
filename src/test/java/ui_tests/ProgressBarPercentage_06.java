package ui_tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DataTableDownloadPage;
import pages.JQueryPage;
import pages.UI01_Page;
import utilities.Driver;
import utilities.ReusableMethods;

public class ProgressBarPercentage_06 {

    UI01_Page page1;
    JQueryPage jQueryPage;
    DataTableDownloadPage dataTableDownload;
    WebDriverWait wait;

    {
        page1 = new UI01_Page();
        jQueryPage = new JQueryPage();
        dataTableDownload = new DataTableDownloadPage();
        wait = new WebDriverWait(Driver.getDriver(), 20);
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
    }

    @Test()
    public void jQueryProgressBar() {
        jQueryPage.jQueryDownloadProgressBar.click();
        ReusableMethods.clickWithJS(jQueryPage.downloadButton);
        wait.until(ExpectedConditions.attributeToBe(jQueryPage.progressPercent, "aria-valuenow", "100"));

        String actualProgressText = jQueryPage.progressText.getText();
        String expectedProgressText = "Complete!";
        Assert.assertEquals(actualProgressText, expectedProgressText);

    }

    @Test()
    public void bootStrapProgressBar() {
        jQueryPage.bootstrapDownloadProgressBar.click();
        ReusableMethods.scrollToElement(jQueryPage.bootStrapDownloadButton);
        ReusableMethods.clickWithJS(jQueryPage.bootStrapDownloadButton);

        WebElement element = wait.until(ExpectedConditions.visibilityOf(jQueryPage.percentageText65));
        String actualResult = element.getText();
        Assert.assertEquals(actualResult, "1%");

    }
}
