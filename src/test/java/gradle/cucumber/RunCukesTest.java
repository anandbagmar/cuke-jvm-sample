package gradle.cucumber;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import cucumber.api.Scenario;
import org.junit.runner.RunWith;
import utils.DriverUtils;

@RunWith(Cucumber.class)
public class RunCukesTest {

    @Before("@browser")
    public void setUp() {
        DriverUtils.resetWebDriver();
    }

    @After("@browser")
    public void takeScreenShot(Scenario scenario) {
        if (scenario.isFailed())
        {
            scenario.embed(DriverUtils.takeScreenShot(), "image/png");
        }
        DriverUtils.quitDriver();
    }
}