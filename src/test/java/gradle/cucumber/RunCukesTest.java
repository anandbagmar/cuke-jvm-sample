package gradle.cucumber;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import cucumber.api.Scenario;
import org.junit.runner.RunWith;
import utils.DriverUtils;
import utils.FileUtils;
import utils.RuntimeUtils;

import java.io.File;

@RunWith(Cucumber.class)
public class RunCukesTest {

    @Before()
    public void commonSetup() {
    }

    @Before("@browser")
    public void setUpWebDriver() {
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