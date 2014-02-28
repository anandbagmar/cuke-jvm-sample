package gradle.cucumber;

import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.testng.annotations.BeforeClass;
import utils.DriverUtils;

@RunWith(Cucumber.class)
public class RunCukesTest {

    @BeforeClass
    public void setUp() {
        DriverUtils.getDriver();
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Ran the after");
        DriverUtils.resetDriver();
    }

}
