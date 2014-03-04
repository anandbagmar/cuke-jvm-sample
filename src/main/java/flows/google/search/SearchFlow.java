package flows.google.search;

import pages.PageUtils;
import pages.SearchPage;
import utils.CustomAsserts;

public class SearchFlow {

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
        CustomAsserts.assertTrue(numberOfSearchResults > 10000000, "Number of search results less than " +
                "10000000. Actual results: " + numberOfSearchResults);
    }
}
