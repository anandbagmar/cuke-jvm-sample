package gradle.cucumber.steps.google;

import businessLayer.google.search.Search;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchSteps {
    @Given("^I am on the google search page$")
    public void I_am_on_the_google_search_page() throws Throwable {
        Search search = new Search();
        search.navigateToSearchPage();
    }

    @When("^I search for \"([^\"]*)\"$")
    public void I_search_for(String searchCriteria) throws Throwable {
        Search search = new Search();
        search.searchFor(searchCriteria);
    }

    @Then("^I see a list of related posts$")
    public void I_see_a_list_of_related_posts() throws Throwable {
        Search search = new Search();
        search.assertSearchResultsFound();
    }
}
