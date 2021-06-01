package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class DragablePage {
    public DragablePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='list-group']//a[.='Drag and Drop']")
    public WebElement dragableMenuLink;

    @FindBy(xpath = "//div[@id='todrag']//span")
    public List<WebElement> dragableItems;

    @FindBy(xpath = "//div[@id='mydropzone']")
    public WebElement dropZone;

}
