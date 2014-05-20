package utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtils extends BaseUtils {
    public static void navigateTo(String url) {
        logger = (Logger) RuntimeUtils.retrieveState("logger");
        logger.info("Navigate to url: " + url);
        DriverUtils.getDriver().get(url);
        DriverUtils.saveScreenShotAs("navigateTo", "Navigate to: " + url);
    }

    public static void waitUntilCSSConditionContains(WebDriver driver, String condition, String waitForContent, int numberOfRetries) {
        logger = (Logger) RuntimeUtils.retrieveState("logger");
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

    public static String selectFromDropDown(WebDriver driver, String selectorID, String valueToSelect) {
        logger = (Logger) RuntimeUtils.retrieveState("logger");
        DriverUtils.saveScreenShotAs("selectFromDropDown", selectorID + "::" + valueToSelect);
        Select dropdown = new Select(driver.findElement(By.cssSelector(selectorID)));
//        for (WebElement webElement : dropdown.getOptions()) {
//            logger.info(webElement.getText());
//        }
        dropdown.selectByVisibleText(valueToSelect);
        String selectedValue = dropdown.getFirstSelectedOption().getText();
        logger.info("Selected value from dropdown list: " + selectorID + ":: " + selectedValue);
        return selectedValue;
    }

    public static void enterValueInInputBox(WebDriver driver, String id, String value) {
        driver.findElement(By.id(id)).clear();
        driver.findElement(By.id(id)).sendKeys(value);
    }

}
