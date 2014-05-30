package utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.webdriver.SikuliFirefoxDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DriverUtils {
    private static WebDriver driver;
    public static boolean isSikuli;

    private static WebDriver startWebDriver() {
        Logger logger = (Logger) RuntimeUtils.retrieveState("logger");
        logger.info("Start WebDriver");
        WebDriver d;
        if (isSikuli) {
            d = new SikuliFirefoxDriver();
        } else {
            d = new FirefoxDriver();
        }
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

    public static String saveScreenShotAs(String fileName, String comment) {
        String savedFileName = fileName;
        Logger logger = (Logger) RuntimeUtils.retrieveState("logger");
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy h-mm-ssa");
        String formattedDate = simpleDateFormat.format(date);

        savedFileName = "build/reports/" + FileUtils.getNormalisedFileName(fileName) + "_" + formattedDate + ".png";
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        screenshot.renameTo(new File(savedFileName));
        logger.info("\n\t" + comment + "\n\t\tScreen shot saved in: " + savedFileName);
        return savedFileName;
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