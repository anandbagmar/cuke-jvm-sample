package pages.mifosX;

import org.openqa.selenium.By;
import pages.BaseUIPage;
import utils.PageUtils;
import utils.DriverUtils;

public class LoginPage extends BaseUIPage {
    private String userNameInputBoxID = "uid";
    private String passwordInputBoxID = "pwd";
    private String signInButtonID = "login-button";

    public void loginas(String username, String password) {
        PageUtils.navigateTo("https://demo.openmf.org");
        driver.findElement(By.id(userNameInputBoxID)).sendKeys(username);
        driver.findElement(By.id(passwordInputBoxID)).sendKeys(password);
        driver.findElement(By.id(signInButtonID)).click();
        DriverUtils.saveScreenShotAs("Login Page", "");
    }
}
