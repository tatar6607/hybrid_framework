package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class UI01_Page {

    public UI01_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@id='btn_basic_example']")
    public WebElement startButton;

    @FindBy(xpath = "//a[.='No, thanks!']")
    public WebElement noThanksButton;

    @FindBy(xpath = "//div[@class='list-group']//a")
    public List<WebElement> allLinks;

    @FindBy(xpath = "//input[@id='user-message']")
    public WebElement messageInput;

    @FindBy(xpath = "//button[.='Show Message']")
    public WebElement showMessageButton;

    @FindBy(xpath = "//span[@id='display']")
    public WebElement messageText;

    @FindBy(xpath = "//input[@id='sum1']")
    public WebElement inputA;

    @FindBy(xpath = "//input[@id='sum2']")
    public WebElement inputB;

    @FindBy(xpath = "//button[.='Get Total']")
    public WebElement getTotalButton;

    @FindBy(xpath = "//span[@id='displayvalue']")
    public WebElement getResultText;




}
