package pages;

import utils.DriverUtils;

public class PageUtils {
    public static void navigateTo(String url) {
        DriverUtils.getDriver().get(url);
        DriverUtils.saveScreenShotAs("navigateTo", "Navigate to: " + url);
    }
}
