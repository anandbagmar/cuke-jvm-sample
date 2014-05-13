package flows.google.search;

import flows.BaseFlow;
import utils.PageUtils;
import pages.google.SearchPage;
import utils.CustomAsserts;

public class SearchFlow extends BaseFlow {

    public void navigateToSearchPage() {
        PageUtils.navigateTo("http://www.google.com");
    }

    public void searchFor(String searchCriteria) {
        SearchPage searchPage = new SearchPage();
        searchPage.searchFor(searchCriteria);
    }

    public void assertSearchResultsFound() {
        SearchPage searchPage = new SearchPage();
        long numberOfSearchResults = searchPage.getNumberOfSearchResults();
        CustomAsserts.assertTrue("Number of search results less than 100. Actual results: " +
                numberOfSearchResults, numberOfSearchResults > 100);
    }
}
