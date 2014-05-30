package pages.maps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ImageTarget;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopMouse;
import org.sikuli.webdriver.ImageElement;
import org.sikuli.webdriver.SikuliFirefoxDriver;
import pages.BaseUIPage;
import utils.RuntimeUtils;

import java.io.File;
import java.net.URL;

public class MapsHome extends BaseUIPage {
    private String searchInputBoxname = "q";
    private String searchButtonclass = "searchbutton";
    private String campImageLocation = RuntimeUtils.ProjectRoot + "/src/main/resources/ImageLocators/camp.png";
    private String directionToHereImageLocation = RuntimeUtils.ProjectRoot + "/src/main/resources/ImageLocators/to_here.png";
    private String defaultRouteCSS = ".cards-directions-details.cards-directions-distance";

    private SikuliFirefoxDriver sikuliDriver;

    public MapsHome() {
        sikuliDriver = (SikuliFirefoxDriver) driver;
    }


    public void searchOnMap(String placeName) {
        sikuliDriver.findElement(By.name(searchInputBoxname)).sendKeys(placeName);
        sikuliDriver.findElement(By.name(searchInputBoxname)).sendKeys(Keys.ESCAPE);
        sikuliDriver.findElement(By.className(searchButtonclass)).click();
    }


    public ImageElement camp() {
        try {
            return sikuliDriver.findImageElement(new URL("file:///" + campImageLocation));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void getDirectionToCamp() {
        Target tg = new ImageTarget(new File(campImageLocation));
        ScreenRegion sr = new DesktopScreenRegion();
        Mouse mouse = new DesktopMouse();
        camp().doubleClick();
        mouse.rightClick(sr.find(tg).getCenter());
        directionToHere().click();
    }

    private ImageElement directionToHere() {
        try {
            return sikuliDriver.findImageElement(new URL("file:///" + directionToHereImageLocation));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String distanceToCamp() {
        return sikuliDriver.findElement(By.cssSelector(defaultRouteCSS)).getText().split(",")[0];

    }
}
