package pages.mifosX;

import org.openqa.selenium.By;
import pages.BaseUIPage;
import utils.PageUtils;
import utils.DriverUtils;
import utils.RuntimeUtils;

public class LoginPage extends BaseUIPage {
    private String userNameInputBoxID = "uid";
    private String passwordInputBoxID = "pwd";
    private String signInButtonID = "login-button";

    public void loginAs(String username, String password) {
        RuntimeUtils.saveState("currentPage", this);

        PageUtils.navigateTo("https://demo.openmf.org");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id(userNameInputBoxID)).sendKeys(username);
        driver.findElement(By.id(passwordInputBoxID)).sendKeys(password);
        driver.findElement(By.id(signInButtonID)).click();
        DriverUtils.saveScreenShotAs("Login Page", "");
    }
}
