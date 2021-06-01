package ui_tests;

import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DataTableDownloadPage;

import pages.DragablePage;
import pages.UI01_Page;
import utilities.Driver;
import utilities.ReusableMethods;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;

public class DragableTest_08 {
    UI01_Page page1;
    DragablePage dragablePage;
    DataTableDownloadPage dataTableDownload;
    WebDriverWait wait;
    Actions actions;

    {
        page1 = new UI01_Page();
        dragablePage = new DragablePage();
        dataTableDownload = new DataTableDownloadPage();
        wait = new WebDriverWait(Driver.getDriver(), 20);
        actions = new Actions(Driver.getDriver());
    }

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get("https://www.seleniumeasy.com/test/");

        try {
            page1.noThanksButton.click();
        } catch (Exception ignored) {

        }
        ReusableMethods.scrollToElement(dataTableDownload.advancedArrow);
        dataTableDownload.advancedArrow.click();
        dragablePage.dragableMenuLink.click();
    }

    @Test
    public void TC_01() {
        for (WebElement w : dragablePage.dragableItems) {
            ReusableMethods.waitFor(1);
            Actions a = actions.moveToElement(w).clickAndHold().
                    moveToElement(dragablePage.dropZone).
                    release();
            a.perform();
        }
    }

    @Test
    public void TC_03() throws IOException {
//        new Actions(Driver.getDriver())
//                .moveToElement(dragablePage.dragableItems.get(0))
//                .pause(Duration.ofSeconds(1))
//                .clickAndHold(dragablePage.dragableItems.get(0))
//                .pause(Duration.ofSeconds(1))
//                .moveByOffset(1, 0)
//                .moveToElement(dragablePage.dropZone)
//                .moveByOffset(1, 0)
//                .pause(Duration.ofSeconds(1))
//                .release().perform();

        String filePath = "src/test/java/utilities/dnd.js";
        String source = "span[draggable='true']";
        String target = "#mydropzone";
        StringBuffer buffer = new StringBuffer();
        Files.lines(Path.of(filePath)).forEach(buffer::append);

//        StringBuffer buffer = new StringBuffer();
//        String line;
//        BufferedReader br = new BufferedReader(new FileReader(filePath));
//        while((line = br.readLine())!=null) {
//            buffer.append(line);
//        }


        String javaScript = buffer.toString();

        javaScript = javaScript + "$('" + source + "').simulateDragDrop({ dropTarget: '" + target + "'});";
        ((JavascriptExecutor) Driver.getDriver()).executeScript(javaScript);

    }

    @Test
    public void TC_02() throws InterruptedException, AWTException {
//        Point coordinates = Driver.getDriver().findElement(By.xpath("//div[@id='todrag']//span[3]")).getLocation();
//        Point coordinatesa = Driver.getDriver().findElement(By.xpath("//*[@id='mydropzone']")).getLocation();

//        Point coordinates = dragablePage.dragableItems.get(0).getLocation();
//        Point coordinatesa = dragablePage.dropZone.getLocation();
//        Robot robot = new Robot();
//        robot.mouseMove(coordinates.getX(), coordinates.getY());
//        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//        robot.mouseMove(coordinatesa.getX() + 100, coordinatesa.getY() + 130);
//        Thread.sleep(500);
//        robot.mouseMove(coordinatesa.getX() + 200, coordinatesa.getY() + 30);
//        robot.delay(2000);
//        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);


//        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
//        js.executeScript("function createEvent(typeOfEvent) {\n" +"var event =document.createEvent(\"CustomEvent\");\n" +"event.initCustomEvent(typeOfEvent,true, true, null);\n" +"event.dataTransfer = {\n" +"data: {},\n" +"setData: function (key, value) {\n" +"this.data[key] = value;\n" +"},\n" +"getData: function (key) {\n" +"return this.data[key];\n" +"}\n" +"};\n" +"return event;\n" +"}\n" +"\n" +"function dispatchEvent(element, event,transferData) {\n" +"if (transferData !== undefined) {\n" +"event.dataTransfer = transferData;\n" +"}\n" +"if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n" +"} else if (element.fireEvent) {\n" +"element.fireEvent(\"on\" + event.type, event);\n" +"}\n" +"}\n" +"\n" +"function simulateHTML5DragAndDrop(element, destination) {\n" +"var dragStartEvent =createEvent('dragstart');\n" +"dispatchEvent(element, dragStartEvent);\n" +"var dropEvent = createEvent('drop');\n" +"dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n" +"var dragEndEvent = createEvent('dragend');\n" +"dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" +"}\n" +"\n" +"var source = arguments[0];\n" +"var destination = arguments[1];\n" +"simulateHTML5DragAndDrop(source,destination);",dragablePage.dragableItems.get(0), dragablePage.dropZone);
//        Thread.sleep(1500);


        final String java_script =
                "var src=arguments[0],tgt=arguments[1];var dataTransfer={dropEffe" +
                        "ct:'',effectAllowed:'all',files:[],items:{},types:[],setData:fun" +
                        "ction(format,data){this.items[format]=data;this.types.append(for" +
                        "mat);},getData:function(format){return this.items[format];},clea" +
                        "rData:function(format){}};var emit=function(event,target){var ev" +
                        "t=document.createEvent('Event');evt.initEvent(event,true,false);" +
                        "evt.dataTransfer=dataTransfer;target.dispatchEvent(evt);};emit('" +
                        "dragstart',src);emit('dragenter',tgt);emit('dragover',tgt);emit(" +
                        "'drop',tgt);emit('dragend',src);";


        for (WebElement w : dragablePage.dragableItems) {
            ((JavascriptExecutor) Driver.getDriver()).executeScript(java_script, w, dragablePage.dropZone);
            Thread.sleep(2000);
        }


    }


}
