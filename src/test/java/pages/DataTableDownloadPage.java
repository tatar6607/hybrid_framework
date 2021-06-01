package pages;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.io.IOException;
import java.util.List;

public class DataTableDownloadPage {
    public DataTableDownloadPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@id='advanced_example']")
    public WebElement advancedArrow;

    @FindBy(xpath = "//div[@class='list-group']//a[.='Table Data Download']")
    public WebElement dataTableDownloadLink;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement searchBox;

    @FindBy(xpath = "//tbody/tr/td[3]")
    public List<WebElement> searchResultCities;

    @FindBy(xpath = "//div[@class='dt-buttons']/a[4]")
    public WebElement pdfDownloadButton;


    public String pdfToText() {
        String fileName = "Selenium Easy - Download Table Data to CSV, Excel, PDF and Print.pdf";
        String filePath = System.getProperty("user.home") + "\\Downloads\\" + fileName;
        String page = "";
        try {
            PdfReader reader = new PdfReader(filePath);
            page = PdfTextExtractor.getTextFromPage(reader, 1);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return page;
    }
}
