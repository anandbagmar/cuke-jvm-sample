package gradle.cucumber;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.DriverUtils;

public class BaseSteps {

    @Before
    public void setUp() {
        DriverUtils.getDriver();
    }

    @After
    public void tearDown() {
        DriverUtils.resetDriver();
    }
}