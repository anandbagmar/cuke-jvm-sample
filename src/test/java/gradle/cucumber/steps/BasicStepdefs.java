package gradle.cucumber.steps;

import cucumber.api.java.en.*;
import flows.gradle.cucumber.Production;

import java.lang.Throwable;

public class BasicStepdefs {

    @When("^I run a failing step")
    public void I_run_a_failing_step() throws Throwable {
        new Production().doFailingWork();
    }

    @Given("^I run a passing step")
    public void I_run_a_passing_step() throws Throwable {
        new Production().doPassingWork();
    }
}
