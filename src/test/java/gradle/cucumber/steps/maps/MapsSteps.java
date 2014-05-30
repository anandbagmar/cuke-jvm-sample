package gradle.cucumber.steps.maps;

import businessLayer.maps.Maps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class MapsSteps {
    @Given("^I am on google maps home page$")
    public void I_am_on_google_maps_home_page() throws Throwable {
        Maps maps = new Maps();
        maps.openMap();
    }

    @When("^I search for \"([^\"]*)\" on map$")
    public void I_search_for_on_map(String source) throws Throwable {
        Maps maps = new Maps();
        maps.searchForLocation(source);
    }

    @When("^I locate Camp and get direction$")
    public void I_locate_Camp_and_get_direction() throws Throwable {
        Maps maps = new Maps();
        maps.getDirectionToCamp();
    }

    @Then("^I should see that Camp is \"([^\"]*)\" from Pune$")
    public void I_should_see_that_Camp_is_from_Pune(String expectedDistance) throws Throwable {
        Maps maps = new Maps();
        maps.assertdistanceTillCampIs(expectedDistance);
    }
}
