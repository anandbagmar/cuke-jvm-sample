package gradle.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.DataTable;

import java.util.List;
import java.util.Map;

import static utils.FileUtils.loadJsonSectionFrom;
import static utils.RuntimeUtils.retrieveEntitySection;
import static utils.RuntimeUtils.loadfile;

public class CreateCustomer {
    @Given("^I create a new Individual Customer$")
    public void I_create_a_new_Individual_Customer(DataTable entities) throws Throwable {
        List<Map<String,String>> entitiesToUse = entities.asMaps();
        for(Map<String,String> eachEntity: entitiesToUse){
            for(String key: eachEntity.keySet()){
                System.out.println("key: " + key + " , value: " + eachEntity.get(key));
                loadJsonSectionFrom(loadfile(eachEntity), retrieveEntitySection(eachEntity));
            }
        }
    }
}
