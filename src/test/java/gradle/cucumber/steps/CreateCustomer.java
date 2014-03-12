package gradle.cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.DataTable;
import cucumber.api.java.en.When;
import gherkin.deps.com.google.gson.internal.StringMap;
import utils.EntityUtils;

import java.util.HashMap;

import static utils.FileUtils.loadJsonEntityFrom;

public class CreateCustomer {
    @Given("^I create a new Individual Customer$")
    public void I_create_a_new_Individual_Customer(DataTable entities) throws Throwable {
        HashMap<String, StringMap> loadedTestData = EntityUtils.getTestDataFromEntities(entities);
    }

    @When("^I load test data implicitly$")
    public void I_load_test_data_implicitly() throws Throwable {
        HashMap<String, StringMap> loadedTestData = EntityUtils.getTestDataFromEntities("addresses", "bne_res_4");
    }
}
