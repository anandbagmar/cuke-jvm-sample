package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.DriverUtils;

public class SearchPage extends BasePage {
    private final WebDriver driver;
    private String searchInputBoxId = "gbqfq";
    private String searchButtonId = "gbqfb";
    private String numberOfSearchResultsId = "resultStats";

    public SearchPage() {
        driver = DriverUtils.getDriver();
    }

    public void searchFor(String searchCriteria) {
        enterSearchCriteria(searchCriteria);
        search();
    }

    private void enterSearchCriteria(String searchCriteria) {
        logger.info("enterSearchCriteria: " + searchCriteria);
        driver.findElement(By.id(searchInputBoxId)).sendKeys(searchCriteria);
    }

    private void search() {
        driver.findElement(By.id(searchButtonId)).click();
    }

    public int getNumberOfSearchResults() {
        String numberOfSearchResults = driver.findElement(By.id(numberOfSearchResultsId)).getText();
        numberOfSearchResults = numberOfSearchResults.replaceAll("About ", "").replaceAll(" results.*", "").replaceAll(",","");
        logger.info("numberOfSearchResults: " + numberOfSearchResults);
        return Integer.valueOf(numberOfSearchResults);
    }
}
