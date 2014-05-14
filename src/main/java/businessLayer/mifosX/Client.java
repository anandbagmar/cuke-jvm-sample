package businessLayer.mifosX;

import businessLayer.Base;
import pages.mifosX.ClientPage;
import pages.mifosX.CreateClientPage;
import utils.CustomAsserts;

public class Client extends Base {
    public void createClient(String firstName, String lastName) {
        Login login = new Login();
        login.loginAsAdmin();

        CreateClientPage createClientPage = new CreateClientPage();
        createClientPage.createClientWithMiniumInformation(firstName, lastName);

        ClientPage clientPage = new ClientPage();
        CustomAsserts.assertContains("First name incorrect ", firstName, clientPage.createdClientInformation());
        CustomAsserts.assertContains("Last name incorrect ", lastName, clientPage.createdClientInformation());
    }
}
