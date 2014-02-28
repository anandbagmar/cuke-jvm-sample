package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverUtils {
    private static WebDriver driver;

    private static WebDriver startWebDriver() {
        System.out.println("Start WebDriver");
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
        System.out.println("Quit WebDriver");
        if (driver != null) driver.quit();
        driver = null;
    }
}