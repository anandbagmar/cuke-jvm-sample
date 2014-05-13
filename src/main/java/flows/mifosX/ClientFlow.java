package flows.mifosX;

import flows.BaseFlow;
import pages.mifosX.ClientPage;
import pages.mifosX.CreateClientPage;
import utils.CustomAsserts;

public class ClientFlow extends BaseFlow {
    public void createClient(String firstName, String lastName) {
        LoginFlow loginFlow = new LoginFlow();
        loginFlow.loginAsAdmin();

        CreateClientPage createClientPage = new CreateClientPage();
        createClientPage.createClientWithMiniumInformation(firstName, lastName);

        ClientPage clientPage = new ClientPage();
        CustomAsserts.assertContains("First name incorrect ", firstName, clientPage.createdClientInformation());
        CustomAsserts.assertContains("Last name incorrect ", lastName, clientPage.createdClientInformation());
    }
}
