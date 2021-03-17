package ui_tests;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AjaxFormPage;
import pages.UI01_Page;
import pages.UI04_Page;
import utilities.Driver;
import utilities.ReadTxt;

import java.nio.file.Files;
import java.nio.file.Paths;

public class UI04Test {

    UI01_Page page1;
    AjaxFormPage ajaxFormPage;
    Actions actions;
    WebDriverWait wait;
    UI04_Page ui04Page;

    {
        page1 = new UI01_Page();
        ajaxFormPage = new AjaxFormPage();
        actions = new Actions(Driver.getDriver());
        wait = new WebDriverWait(Driver.getDriver(), 10);
        ui04Page = new UI04_Page();
    }

    @BeforeMethod
    public void setup() {
        Driver.getDriver().get("https://www.seleniumeasy.com/test/");

        try {
            page1.noThanksButton.click();
        } catch (Exception ignored) {

        }

        ajaxFormPage.intermediateArrow.click();
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
    }

    @Test
    public void TC01() {
        ui04Page.jQueryListBoxLink.click();

        String [] allNames = {"Valentina", "Giovanna","Helena", "Lara","Julia" };
        ui04Page.selectAllOptions(allNames,ui04Page.getjQueryDropDown);
        ui04Page.addButton.click();

        Select select = new Select(ui04Page.getjQueryDropDown);
        int leftDropDownSize = select.getOptions().size();

        select = new Select(ui04Page.resultDropDown);
        int rightDropDownSize = select.getOptions().size();

        Assert.assertTrue(leftDropDownSize==10 && rightDropDownSize ==5);

    }

    @Test
    public void TC02() {
        ui04Page.dataListFilterLink.click();

        for(WebElement  w : ui04Page.allEmails) {
            Assert.assertTrue(w.getText().contains("@company.com"));
        }

        String name = "Brian Hoyies";
        ui04Page.searchTextBox.sendKeys(name);

        Assert.assertTrue(ui04Page.filteredName.isDisplayed());
    }

    @Test
    public void TC03() {
        ui04Page.fileDownloadLink.click();

        String text = "Selenium practice yapiyorum!";
        ui04Page.textarea.sendKeys(text);
        String count = ui04Page.textareaRemaining.getText().substring(0,ui04Page.textareaRemaining.getText().indexOf(" "));
        int countInt = Integer.parseInt(count);

        Assert.assertTrue(countInt == 500-text.length());

        ui04Page.generateButton.click();
        ui04Page.downloadLink.click();

        String fileName = ui04Page.downloadLink.getAttribute("download");
        String downloadPath = System.getProperty("user.home") + "\\Downloads\\" + "" + fileName;

        boolean isFileExist = Files.exists(Paths.get(downloadPath));
        Assert.assertTrue(isFileExist);

        Assert.assertEquals(ReadTxt.readTxt(downloadPath).get(0),text);

    }

    @AfterClass
    public void tearDown() {
        Driver.closeDriver();
    }
}
