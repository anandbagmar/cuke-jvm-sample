package pages.mifosX;

import org.openqa.selenium.By;
import pages.BaseUIPage;
import utils.PageUtils;
import utils.DriverUtils;
import utils.RuntimeUtils;

public class CreateClientPage extends BaseUIPage {
    private String firstNameID = "firstname";
    private String lastNameID = "lastname";
    private String submitButtonID = "save";

    public CreateClientPage() {
        RuntimeUtils.saveState("currentPage", this);

        PageUtils.navigateTo("https://demo.openmf.org/#/clients");
        DriverUtils.saveScreenShotAs("Clients Page", "");
    }

    public ViewClientPage createClientWithMiniumInformation(String firstName, String lastName) {
        PageUtils.navigateTo(("https://demo.openmf.org/#/createclient"));
        DriverUtils.saveScreenShotAs("Create Client Page", "");

        logger.info(("Create Client for: " + firstName + ", " + lastName));
        driver.findElement(By.id(firstNameID)).sendKeys(firstName);
        driver.findElement(By.id(lastNameID)).sendKeys(lastName);
        driver.findElement(By.id(submitButtonID)).click();

        return new ViewClientPage();
    }
}
