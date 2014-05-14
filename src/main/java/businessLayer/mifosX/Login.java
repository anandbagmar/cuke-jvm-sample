package businessLayer.mifosX;

import businessLayer.Base;
import pages.mifosX.LoginPage;

public class Login extends Base {
    public void loginAsAdmin() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginas("mifos", "password");
    }
}
