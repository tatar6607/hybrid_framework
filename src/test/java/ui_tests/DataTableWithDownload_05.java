package ui_tests;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DataTableDownloadPage;
import pages.UI01_Page;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class DataTableWithDownload_05 {

    UI01_Page page1;
    DataTableDownloadPage dataTableDownload;
    WebDriverWait wait;

    {
        page1 = new UI01_Page();
        dataTableDownload = new DataTableDownloadPage();
        wait = new WebDriverWait(Driver.getDriver(), 20);
    }

    @BeforeClass
    public void setUp() {
        Driver.getDriver().get("https://www.seleniumeasy.com/test/");

        try {
            page1.noThanksButton.click();
        } catch (Exception ignored) {

        }
        ReusableMethods.scrollToElement(dataTableDownload.advancedArrow);
        dataTableDownload.advancedArrow.click();
        dataTableDownload.dataTableDownloadLink.click();
    }

    @Test
    public void Tc01() {
        String date = "2012";
        dataTableDownload.searchBox.sendKeys(date);
        List<WebElement> allCities = wait.until(ExpectedConditions.visibilityOfAllElements(dataTableDownload.searchResultCities));
        List<String> allCitiesTexts = ReusableMethods.getElementsText(allCities);
        Set<String> notDuplicateCities = new HashSet<>(allCitiesTexts);
        Assert.assertEquals(notDuplicateCities.size(), 4);
    }

    @Test
    public void TC02() throws IOException {
        ReusableMethods.waitFor(2);
        String city = "London";
        dataTableDownload.searchBox.sendKeys(city);
        dataTableDownload.pdfDownloadButton.click();

        String fileName = "Selenium Easy - Download Table Data to CSV, Excel, PDF and Print.pdf";
        String filePath = System.getProperty("user.home") + "\\Downloads\\" + fileName;

        wait.until(d -> Paths.get(filePath).toFile().exists());

        boolean isFileExist = Files.exists(Path.of(filePath));
        Assert.assertTrue(isFileExist);

        String pdfData = dataTableDownload.pdfToText();
//        System.out.println("pdfData = " + pdfData);

        String [] lines = pdfData.split(" ");
        System.out.println("lines.length = " + lines.length);

        int cityCount = (int) Arrays.stream(lines).filter(t->t.toLowerCase().equals("london")).count();
        System.out.println("cityCount = " + cityCount);

        Set<String> london = Arrays.stream(lines).filter(t->t.toLowerCase().equals("london")).collect(Collectors.toSet());
        System.out.println("london = " + london);
    }


}
