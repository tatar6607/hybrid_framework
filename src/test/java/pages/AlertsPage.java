package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.*;

public class AlertsPage {

    public AlertsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//a[@class='list-group-item'])[5] ")
    public WebElement alertPageLink;

    @FindBy(xpath = "//button[.='Click me!']")
    public List<WebElement> clickMeButtons;

    @FindBy(xpath = "//p[@id='confirm-demo']")
    public WebElement alertMassage;

    @FindBy(xpath = "//button[.='Click for Prompt Box']")
    public WebElement clickMeButton3;

    @FindBy(xpath = "//p[@id='prompt-demo']")
    public WebElement sendKeyMassage;

}
