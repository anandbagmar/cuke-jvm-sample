package businessLayer.mifosX;

import businessLayer.Base;
import pages.mifosX.ClientActivationPage;
import pages.mifosX.ViewClientPage;
import pages.mifosX.CreateClientPage;
import utils.CustomAsserts;
import utils.RuntimeUtils;

public class Client extends Base {
    public void createClient(String firstName, String lastName) {
        Login login = new Login();
        login.loginAsAdmin();

        CreateClientPage createClientPage = new CreateClientPage();
        ViewClientPage viewClientPage = createClientPage.createClientWithMiniumInformation(firstName, lastName);

        CustomAsserts.assertContains("First name incorrect ", firstName, viewClientPage.createdClientInformation());
        CustomAsserts.assertContains("Last name incorrect ", lastName, viewClientPage.createdClientInformation());

        RuntimeUtils.saveState("client#", viewClientPage.getCreatedClientNumber());
    }

    public void activateClient() {
        ClientActivationPage clientActivationPage = new ClientActivationPage();
        ViewClientPage viewClientPage = clientActivationPage.activate();
        CustomAsserts.assertTrue("Client not activated", viewClientPage.isActivated());
    }
}
