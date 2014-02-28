package flows.google.search;

import pages.PageUtils;
import pages.SearchPage;
import org.junit.Assert;

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
        Assert.assertTrue (searchPage.getNumberOfSearchResults()>10000000);
    }
}
