package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverUtils {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            System.out.println("Init webdriver");
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(60,TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void resetDriver() {
        System.out.println("Reset webdriver");
        driver.quit();
        driver = null;
    }
}