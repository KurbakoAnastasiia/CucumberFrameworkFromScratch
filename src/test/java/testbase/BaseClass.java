package testbase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import utils.ConfigsReader;
import utils.Constants;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static WebDriver driver;

    /**
     * This method opens the browser, sets up configuration and navigates to the URL
     */
    public static void setUp() {
            ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
            switch (ConfigsReader.getPropertyValue("browser").toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    // set up headless browser
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.setHeadless(true);
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "internet explorer":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                default:
                    throw new RuntimeException("Ivalid browser");
            }
        driver.get(ConfigsReader.getPropertyValue("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Constants.PAGELOAD, TimeUnit.SECONDS);

    }

    /**
     * This method closes any open browser
     */
    public static void tearDown() {
        if(driver!=null){
            driver.quit();
        }
    }
}