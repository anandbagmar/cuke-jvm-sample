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
        HashMap<String, String> loadEntities = EntityUtils.entitiesToBeLoaded(entities);
        for (String jsonFile: loadEntities.keySet()) {
            StringMap loadedJson = (StringMap) loadJsonEntityFrom(jsonFile, loadEntities.get(jsonFile));
            System.out.println("loadedJson: " + loadedJson.size());
            for (Object key: loadedJson.keySet()) {
                System.out.println ("\t" + key.toString() + " : " + loadedJson.get(key));
            }
       }
    }
}
