package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    // Her zaman kullandigimiz methodlari ortak bir yerde tutmak icin TestBase Classini kullaniriz.
    protected WebDriver driver;  // Baska package den kullanilacagi icin protected yaptik.
    protected Actions actions ; // Baska package lerden gorulsun ve tum methodlara etki etsin .
    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions =  new Actions(driver);

    }

    @AfterMethod
    public void tearDown() {
//        driver.quit();
    }

}
