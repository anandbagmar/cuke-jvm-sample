package pages.mifosX;

import org.joda.time.DateTime;
import org.openqa.selenium.By;
import pages.BaseUIPage;
import utils.PageUtils;
import utils.DriverUtils;
import utils.RuntimeUtils;

import java.sql.Driver;

public class ViewClientPage extends BaseUIPage {

    private String clientTableSelector = ".table.view-table.table-bordered";
    private String clientInfoTableText = "";
    private String clientNumber = "";
    private String activationDate = "";


    public ViewClientPage() {
        DriverUtils.saveScreenShotAs("View Clients Page", "");
        if (RuntimeUtils.retrieveState("clientNumber") != null) {
            int clientNumber = Integer.parseInt(RuntimeUtils.retrieveState("clientNumber").toString());
            if (!driver.getCurrentUrl().equals("https://demo.openmf.org/#/viewclient/" + clientNumber)) {
                PageUtils.navigateTo("https://demo.openmf.org/#/viewclient/" + clientNumber);
            }
        }
        RuntimeUtils.saveState("currentPage", this);

        PageUtils.waitUntilCSSConditionContains(driver, clientTableSelector, "First Name", 5);
        DriverUtils.saveScreenShotAs("Created Client Page_1", "");
        clientInfoTableText = createdClientInformation();
        parseClientInformation();
        logger.info("clientInfoTableText: \n" + clientInfoTableText);
    }

    private void parseClientInformation() {
        for (String s : clientInfoTableText.split("\n")) {
            try {
                if (s.contains("Client # ")) {
                    clientNumber = s.split("Client # ")[1];
                    logger.info("client number: " + clientNumber + ", " + Integer.parseInt(clientNumber));
                    RuntimeUtils.saveState("clientNumber", Integer.parseInt(clientNumber));
                } else if (s.contains("Activation date ")) {
                    activationDate = s.split("Activation date ")[1];
                    logger.info(("activationDate: " + activationDate));
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                logger.info("Error in splitting client information for line:: " + s);
                DriverUtils.saveScreenShotAs("parseClientInformation","");
            }
        }
        ;
    }

    public String createdClientInformation() {
        return driver.findElement(By.cssSelector(clientTableSelector)).getText();
    }

    public String getCreatedClientNumber() {
        return clientNumber;
    }

    public boolean isActivated() {
        boolean isClientActivated = !(activationDate == "" || activationDate == "Not activated");
        logger.info("Client activation status: " + isClientActivated);
        return isClientActivated;
    }
}
