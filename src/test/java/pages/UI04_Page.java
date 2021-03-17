package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

import java.util.List;

public class UI04_Page {

    public UI04_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='list-group']//a[.='JQuery List Box']")
    public WebElement jQueryListBoxLink;

    @FindBy(xpath = "//select[@class='form-control pickListSelect pickData']")
    public WebElement getjQueryDropDown;

    public void selectAllOptions(String [] allnames , WebElement element ) {
        Select select = new Select(element);
        for (String name : allnames ) {
            select.selectByVisibleText(name);
        }
    }
    @FindBy(xpath = "//button[.='Add']")
    public WebElement addButton;

    @FindBy(xpath = "//select[@class='form-control pickListSelect pickListResult']")
    public WebElement resultDropDown;

    @FindBy(xpath = "//div[@class='list-group']//a[.='Data List Filter']")
    public WebElement dataListFilterLink;

    @FindBy(xpath = "//span[contains(text(),'Email:')]")
    public List<WebElement> allEmails;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement searchTextBox;

    @FindBy(xpath = "//h4[contains(text(),'Name: Brian Hoyies')]")
    public WebElement filteredName;

    @FindBy(xpath = "//div[@class='list-group']//a[.='File Download']")
    public WebElement fileDownloadLink;

    @FindBy(xpath = "//textarea[@id='textbox']")
    public WebElement textarea;

    @FindBy(xpath = "//div[@id='textarea_feedback']")
    public WebElement textareaRemaining;

    @FindBy(xpath = "//button[@id='create']")
    public WebElement generateButton;

    @FindBy(xpath = "//a[@id='link-to-download']")
    public WebElement downloadLink;













}
