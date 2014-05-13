package utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageUtils {
    public static void navigateTo(String url) {
        DriverUtils.getDriver().get(url);
        DriverUtils.saveScreenShotAs("navigateTo", "Navigate to: " + url);
    }

    public static void waitUntilCSSConditionContains(WebDriver driver, String condition, String waitForContent, int numberOfRetries) {
        Logger logger = (Logger) RuntimeUtils.retrieveState("logger");
        String clientInfoTableText = "";
        int counter = 0;
        logger.info ("waiting for condition: " + condition + "having content: " + waitForContent);
        do {
            try {
                Thread.sleep(1000);
                counter++;
                logger.info(".");
            } catch (InterruptedException e) {}
            logger.debug(counter + "\t" + clientInfoTableText.contains(waitForContent) + "\t" + clientInfoTableText);
            clientInfoTableText = driver.findElement(By.cssSelector(condition)).getText();
        } while (clientInfoTableText.contains(waitForContent) && counter != numberOfRetries);
    }
}
