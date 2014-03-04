package gradle.cucumber.steps.google;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import flows.google.search.SearchFlow;

public class SearchSteps {
    @Given("^I am on the google search page$")
    public void I_am_on_the_google_search_page() throws Throwable {
        SearchFlow searchFlow = new SearchFlow();
        searchFlow.navigateToSearchPage();
    }

    @When("^I search for \"([^\"]*)\"$")
    public void I_search_for(String searchCriteria) throws Throwable {
        SearchFlow searchFlow = new SearchFlow();
        searchFlow.searchFor(searchCriteria);
    }

    @Then("^I see a list of related posts$")
    public void I_see_a_list_of_related_posts() throws Throwable {
        SearchFlow searchFlow = new SearchFlow();
        searchFlow.assertSearchResultsFound();
    }
}
