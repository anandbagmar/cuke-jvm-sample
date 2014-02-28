package gradle.cucumber;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import utils.DriverUtils;

@RunWith(Cucumber.class)
public class RunCukesTest {

    @Before
    public void setUp() {
        DriverUtils.getDriver();
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                DriverUtils.quitDriver();
            }
        });
    }

    @After
    public void afterScenario() {
        
    }


}
