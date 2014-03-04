package flows.google.search;

import pages.PageUtils;
import pages.SearchPage;
import org.junit.Assert;
import utils.RuntimeUtils;

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
        System.out.println("***: " + String.valueOf(numberOfSearchResults));
        RuntimeUtils.taasResponse.put("result_count",String.valueOf(numberOfSearchResults));
        Assert.assertTrue (numberOfSearchResults>10000000);
    }
}
