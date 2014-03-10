package gradle.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.DataTable;
import gherkin.deps.com.google.gson.internal.StringMap;
import utils.EntityUtils;

import java.util.HashMap;

import static utils.FileUtils.loadJsonEntityFrom;

public class CreateCustomer {
    @Given("^I create a new Individual Customer$")
    public void I_create_a_new_Individual_Customer(DataTable entities) throws Throwable {
        HashMap<String, StringMap> loadedTestData = EntityUtils.getTestDataFromEntities(entities);
        System.out.println("Loaded Test Data: ");
        for (Object key : loadedTestData.keySet()) {
            System.out.println("\t" + key.toString() + " : " + loadedTestData.get(key));
        }
    }
}
