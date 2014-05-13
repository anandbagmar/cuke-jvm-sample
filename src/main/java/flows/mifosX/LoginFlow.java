package flows.mifosX;

import flows.BaseFlow;
import pages.mifosX.LoginPage;

public class LoginFlow extends BaseFlow {
    public void loginAsAdmin() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginas("mifos", "password");
    }
}
