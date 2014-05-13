package pages;

import org.openqa.selenium.WebDriver;
import utils.DriverUtils;

public class BaseUIPage extends BasePage {
    protected WebDriver driver;

    public BaseUIPage() {
        driver = DriverUtils.getDriver();
    }
}
