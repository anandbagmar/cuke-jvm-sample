package pages.mifosX;

import org.openqa.selenium.By;
import pages.BaseUIPage;
import utils.PageUtils;
import utils.DriverUtils;

public class ClientPage extends BaseUIPage {

    private String clientTableSelector;

    public ClientPage() {
        DriverUtils.saveScreenShotAs("Created Client Page", "");
        PageUtils.waitUntilCSSConditionContains(driver, ".table.view-table.table-bordered", "First Name", 5);
        DriverUtils.saveScreenShotAs("Created Client Page_1", "");
        String clientInfoTableText = createdClientInformation();
        logger.info("clientInfoTableText: \n" + clientInfoTableText);
    }

    public String createdClientInformation() {
        clientTableSelector = ".table.view-table.table-bordered";
        return driver.findElement(By.cssSelector(clientTableSelector)).getText();
    }
}
