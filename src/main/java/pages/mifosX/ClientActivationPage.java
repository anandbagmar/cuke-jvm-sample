package pages.mifosX;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BaseUIPage;
import utils.DateUtils;
import utils.PageUtils;
import utils.RuntimeUtils;

public class ClientActivationPage extends BaseUIPage {
    private String submitActivationDateID = "save";

    public ClientActivationPage() {
        RuntimeUtils.saveState("currentPage", this);
        int clientNumber = Integer.parseInt(RuntimeUtils.retrieveState("clientNumber").toString());
        PageUtils.navigateTo("https://demo.openmf.org/#/client/" + clientNumber + "/activate");
    }

    public ViewClientPage activate() {
        enterActivationDate();
        submitActivationDate();
        return new ViewClientPage();
    }

    private void submitActivationDate() {
        driver.findElement(By.id(submitActivationDateID)).click();
    }

    private void enterActivationDate() {
        WebElement parentDiv = driver.findElement(By.cssSelector("div[ng-show=showActivationDateField]"));
        parentDiv.findElement(By.cssSelector("input#activationDate")).click();
        parentDiv.findElement(By.cssSelector("input#activationDate")).sendKeys(DateUtils.getTodaysDate());
    }
}
