package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class JQueryPage {

    public JQueryPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='list-group']//a[.='JQuery Download Progress bars']")
    public WebElement jQueryDownloadProgressBar;

    @FindBy(xpath = "//button[@id='downloadButton']")
    public WebElement downloadButton;

    @FindBy(xpath = "//div[@id='progressbar']")
    public WebElement progressPercent;

    @FindBy(xpath = "//div[@class='progress-label']")
    public WebElement progressText;

    @FindBy(xpath = "//div[@class='list-group']//a[.='Bootstrap Download Progress bar']")
    public WebElement bootstrapDownloadProgressBar;

    @FindBy(xpath = "//button[@id='cricle-btn']")
    public WebElement bootStrapDownloadButton;

    @FindBy(xpath = "//div[.='1%']")
    public WebElement percentageText65;


}
