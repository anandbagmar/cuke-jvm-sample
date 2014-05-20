package utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DriverUtils extends BaseUtils {
    private static RemoteWebDriver driver;

    private static WebDriver startWebDriver() {
        logger = (Logger) RuntimeUtils.retrieveState("logger");
        logger.info("Start WebDriver");
        WebDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        firefoxDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        firefoxDriver.manage().timeouts().setScriptTimeout(60,TimeUnit.SECONDS);
        firefoxDriver.manage().window().maximize();
        return firefoxDriver;
    }

    private static PhantomJSDriver startPhantomJS() {
        logger = (Logger) RuntimeUtils.retrieveState("logger");
        logger.info("Start PhantomJS Driver");

        String baseDir = (String) RuntimeUtils.retrieveState("BASEDIR");

        DesiredCapabilities desiredCapabilities = DesiredCapabilities.phantomjs();
        desiredCapabilities.setJavascriptEnabled(true);
        desiredCapabilities.setCapability("loadImages", true);
        desiredCapabilities.setCapability("takesScreenshot", true);

        desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, baseDir + "/lib/phantomjs");

        PhantomJSDriver phantomJSDriver = new PhantomJSDriver(desiredCapabilities);
        phantomJSDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return phantomJSDriver;
    }

    private static RemoteWebDriver startDriver() {
        logger = (Logger) RuntimeUtils.retrieveState("logger");

        String driverType = System.getProperty("driverType");
        driverType = (driverType==null ? "webdriver" : driverType);
        driverType = (String) RuntimeUtils.saveState("driverType", driverType);

        logger.info ("Starting driver of type: " + driverType);

        if (driverType.equals("webdriver")) {
            driver = (RemoteWebDriver) startWebDriver();
        } else if (driverType.equals("phantomjs")) {
            driver = startPhantomJS();
        }
        return driver;
    }

    public static WebDriver resetDriver() {
        if (driver == null) {
            startDriver();
        } else {
            driver.manage().deleteAllCookies();
        }
        return driver;
    }

    public static RemoteWebDriver getDriver() {
        if (driver == null) {
            driver = startDriver();
        }
        return driver;
    }

    public static void quitDriver() {
        logger = (Logger) RuntimeUtils.retrieveState("logger");
        logger.info("Quit WebDriver");
        if (driver != null) driver.quit();
        driver = null;
    }

    public static byte[] takeScreenShot()
    {
        return driver.getScreenshotAs(OutputType.BYTES);
    }

    public static String saveScreenShotAs(String fileName, String comment) {
        String savedFileName = fileName;
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy h-mm-ssa");
        String formattedDate = simpleDateFormat.format(date);

        String baseDir = (String) RuntimeUtils.retrieveState("BASEDIR");
        savedFileName = baseDir + "/build/reports/" + FileUtils.getNormalisedFileName(fileName) + "_" + formattedDate
                + ".png";
        File screenshot = driver.getScreenshotAs(OutputType.FILE);
        screenshot.renameTo(new File(savedFileName));
        logger.info("\n\t" + comment + "\n\t\tScreen shot saved in: " + savedFileName);
        return savedFileName;
    }
}