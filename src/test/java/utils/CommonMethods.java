package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;
import testbase.PageInitializer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class CommonMethods extends PageInitializer {

    /**
     * This method will clear a textbox and send text to it
     * @param element
     * @param textToSend
     */
    public static void sendText(WebElement element, String textToSend) {
        element.clear();
        element.sendKeys(textToSend);
    }

    /**
     * This method will return an object of Explicit wait with time set to 20 sec
     * @return WebDriverWait
     */
    public static WebDriverWait getWait() {
        WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
        return wait;
    }

    /**
     * This method will wait till given element becomes clickable
     * @param element
     */
    public static void waitForClickability(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * This method will wait till given element becomes visible
     * @param element
     */
    public static void waitForVisibality(WebElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * This method will wait till and then click
     * @param element
     */
    public static void click(WebElement element) {
        waitForClickability(element);
        element.click();
    }

    /**
     * This method will return an Object of JavascriptExecutor
     * @return JavascriptExecutor
     */
    public static JavascriptExecutor getJSExecutor(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }

    /**
     * This method will click using JavascriptExecutor
     * @param element
     */
    public static void jsClick(WebElement element) {
        getJSExecutor().executeScript("arguments[0].click()", element);
    }

    /**
     * This method will send text using JavascriptExecutor
     * @param element
     * @param textToSend
     */
    public static void jsSendText(WebElement element, String textToSend) {
        getJSExecutor().executeScript("arguments[0].value='" + textToSend+ ";", element);
    }

    /**
     * This method will take screenshot and save it
     * @param fileName
     */
    public static byte[] takeScreenshot(String fileName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] bytes = ts.getScreenshotAs(OutputType.BYTES);
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(sourceFile, new File(Constants.SCREENSHOT_FILEPATH + fileName + getTimeStamp("yyyy-MM-dd-HH-mm-ss") + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    /**
     * This method will get time stamp
     * @param pattern
     * @return
     */
    public static String getTimeStamp(String pattern) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * This method clicks the checkbox if it is not selected
     * @param webElement
     */
    public static void clickCheckBoxIfIsNotSelected(WebElement webElement) {
        if(!webElement.isSelected()) {
            webElement.click();
        }
    }

    /**
     * this method will click on a radio button or a checkbox by the given list of elements and the value
     * @param radioOrCheckBoxes
     * @param value
     */
    public static void clickRadioOrCheckBox(List<WebElement> radioOrCheckBoxes, String value) {
        for (WebElement radioOrcheckBox : radioOrCheckBoxes) {
            String actualValue = radioOrcheckBox.getAttribute("value").trim();
            if(radioOrcheckBox.isEnabled() && actualValue.equals(value)) {
                click(radioOrcheckBox);
                break;
            }
        }
    }

    /**
     * this method will click on a radio button or a checkbox by the given list of elements and the text value
     * @param radioOrCheckBoxes
     * @param value
     */
    public static void clickRadioOrCheckBoxByText(List<WebElement> radioOrCheckBoxes, String value) {
        for (WebElement radioOrcheckBox : radioOrCheckBoxes) {
            String actualValue = radioOrcheckBox.getText().trim();
            if(radioOrcheckBox.isEnabled() && actualValue.equals(value)) {
                click(radioOrcheckBox);
                break;
            }
        }
    }

    /**
     * this method will select a value from  a given dropDown by the given visible text
     * @param dd
     * @param visibleText
     */
    public static void selectDDValue(WebElement dd, String visibleText) {
        try {
            Select select = new Select(dd);
            List<WebElement> options = select.getOptions();
            for (WebElement option : options) {
                if(option.getText().trim().equals(visibleText)) {
                    select.selectByVisibleText(visibleText);
                }
            }
        } catch (UnexpectedTagNameException e) {
            e.printStackTrace();
        }
    }

    /**
     * this method will select a value from  a given dropDown by the given index
     * @param dd
     * @param index
     */
    public static void selectDDValue(WebElement dd, int index) {
        try {
            Select select = new Select(dd);
            List<WebElement> options = select.getOptions();
            int ddsize = options.size();
            if(ddsize > index) {
                select.selectByIndex(index);
            }
        } catch (UnexpectedTagNameException e) {
            e.printStackTrace();
        }
    }

    /**
     * this method will select a value from  a given dropDown by the given value
     * @param value
     * @param dd
     */
    public static void selectDDValue(String value, WebElement dd) {
        try {
            Select select = new Select(dd);
            List<WebElement> options = select.getOptions();
            for (WebElement option : options) {
                if(option.getAttribute("value").trim().equals(value)) {
                    select.selectByValue(value);
                }
            }
        } catch (UnexpectedTagNameException e) {
            e.printStackTrace();
        }
    }

    public static List<String> storeAllDDValuesIntoList(WebElement element) {
        Select select = new Select(element);
        List<WebElement> options = select.getOptions();
        List<String> allValuesDD = null;
        for (WebElement option : options) {
            String optiontext = option.getText();
            allValuesDD.add(optiontext);
        }
        return allValuesDD;
    }

    /**
     * this method will switch to aframe by the given index
     * @param frameIndex
     */
    public static void switchToFrame(int frameIndex) {
        try {
            driver.switchTo().frame(frameIndex);
        } catch (NoSuchFrameException e) {
            e.printStackTrace();
        }
    }

    /**
     * this method will switch to aframe by the given name or id
     * @param nameOrId
     */
    public static void switchToFrame(String nameOrId) {
        try {
            driver.switchTo().frame(nameOrId);
        } catch (NoSuchFrameException e) {
            e.printStackTrace();
        }
    }

    /**
     * this method will switch to a frame by the given webElement
     * @param webElement
     */
    public static void switchToFrame(WebElement webElement){
        try {
            driver.switchTo().frame(webElement);
        }catch (NoSuchFrameException e){
            e.printStackTrace();
        }
    }

    /**
     * this method will switch to a child window
     */
    public static void switchToChildWindow() {
        String mainWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if(!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }

    /**
     * This method will return and Object of Actions class
     * @return
     */
    public static Actions getAction() {
        Actions action = new Actions(driver);
        return action;
    }

    /**
     * This method will move to element with help of Action Class
     * @param element
     */
    public static void moveToElementAction(WebElement element) {
        getAction().moveToElement(element).perform();
    }

    /**
     * This method reads any files in json formats
     * @param FileName
     * @return
     */
    static String jsonFile;
    public static String readJson(String FileName){
        try {
            jsonFile = new String (Files.readAllBytes(Paths.get(FileName)));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return jsonFile;
    }
}
