package utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverUtils {
    private static WebDriver driver;

    private static WebDriver startWebDriver() {
        Logger logger = (Logger) RuntimeUtils.retrieveState("logger");
        logger.info("Start WebDriver");
        WebDriver d = new FirefoxDriver();
        d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        d.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        d.manage().timeouts().setScriptTimeout(60,TimeUnit.SECONDS);
        d.manage().window().maximize();
        return d;
    }

    public static byte[] takeScreenShot()
    {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public static WebDriver resetWebDriver() {
        if (driver == null) {
            driver = startWebDriver();
        }
        else
        {
            driver.manage().deleteAllCookies();
        }
        return driver;
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = startWebDriver();
        }
        return driver;
    }

    public static void quitDriver() {
        Logger logger = (Logger) RuntimeUtils.retrieveState("logger");
        logger.info("Quit WebDriver");
        if (driver != null) driver.quit();
        driver = null;
    }
}