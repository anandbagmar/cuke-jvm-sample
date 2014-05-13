package pages.mifosX;

import org.openqa.selenium.By;
import pages.BaseUIPage;
import utils.PageUtils;
import utils.DriverUtils;

public class CreateClientPage extends BaseUIPage {
    private String officeID = "";
    private String firstNameID = "firstname";
    private String lastNameID = "lastname";
    private String submitButtonID = "save";

    public CreateClientPage() {
        PageUtils.navigateTo("https://demo.openmf.org/#/clients");
        DriverUtils.saveScreenShotAs("Clients Page", "");
    }

    public void createClientWithMiniumInformation(String firstName, String lastName) {
        PageUtils.navigateTo(("https://demo.openmf.org/#/createclient"));
        DriverUtils.saveScreenShotAs("Create Client Page", "");

        driver.findElement(By.id(firstNameID)).sendKeys(firstName);
        driver.findElement(By.id(lastNameID)).sendKeys(lastName);
        driver.findElement(By.id(submitButtonID)).click();
        DriverUtils.saveScreenShotAs("Clients Page", "");
    }
}
