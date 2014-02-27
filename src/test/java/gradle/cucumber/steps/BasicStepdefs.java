package gradle.cucumber;

import cucumber.api.java.en.*;
import java.lang.Throwable;

public class BasicStepdefs extends BaseStepdefs{

    @When("^I run a failing step")
    public void I_run_a_failing_step() throws Throwable {
        new Production().doFailingWork();
    }

    @Given("^I run a passing step")
    public void I_run_a_passing_step() throws Throwable {
        new Production().doPassingWork();
    }
}
