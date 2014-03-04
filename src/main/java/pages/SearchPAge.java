package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.DriverUtils;
import utils.RuntimeUtils;

public class SearchPage {
    private final WebDriver driver;
    private String searchInputBoxId = "gbqfq";
    private String searchButtonId = "gbqfb";
    private String numberOfSearchResultsId = "resultStats";

    public SearchPage() {
        driver = DriverUtils.getDriver();
    }

    public void searchFor(String searchCriteria) {
        if(RuntimeUtils.taasParams.containsKey("search_for")) {
            searchCriteria = RuntimeUtils.taasParams.get("search_for");
        }
        enterSearchCriteria(searchCriteria);
        search();
    }

    private void enterSearchCriteria(String searchCriteria) {
        System.out.println("enterSearchCriteria: " + searchCriteria);
        driver.findElement(By.id(searchInputBoxId)).sendKeys(searchCriteria);
    }

    private void search() {
        driver.findElement(By.id(searchButtonId)).click();
    }

    public long getNumberOfSearchResults() {
        String numberOfSearchResults = driver.findElement(By.id(numberOfSearchResultsId)).getText();
        numberOfSearchResults = numberOfSearchResults.replaceAll("About ", "").replaceAll(" results.*", "").replaceAll(",","");
        System.out.println("numberOfSearchResults: " + numberOfSearchResults);
        return Long.valueOf(numberOfSearchResults);
    }
}
