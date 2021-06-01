package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AngularDDMPage {

    public AngularDDMPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//mat-select[@id='mat-select-0']")
    public WebElement firstDropDownMenu;

    public void clickFirstDropDownMenu() {
        firstDropDownMenu.click();
    }

    @FindBy(xpath = "//mat-option")
    public List<WebElement> firstDropDownAllElements;

    @FindBy(xpath = "//span[@class='mat-select-min-line ng-tns-c143-4 ng-star-inserted']")
    public WebElement firstDropDownSelectedElement;




}
