package businessLayer.maps;

import businessLayer.Base;
import pages.maps.MapsHome;
import utils.CustomAsserts;
import utils.PageUtils;

/**
 * Created with IntelliJ IDEA.
 * User: rajdeepverma
 * Date: 5/14/14
 * Time: 5:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class Maps extends Base {
    public void openMap() {
        PageUtils.navigateTo("http://maps.google.com");
    }

    public void searchForLocation(String searchCriteria) {
        MapsHome mapsHome = new MapsHome();
        mapsHome.searchOnMap(searchCriteria);
    }

    public void getDirectionToCamp() {
        MapsHome mapsHome = new MapsHome();
        mapsHome.getDirectionToCamp();


    }

    public void assertdistanceTillCampIs(String expectedDistance) {
        MapsHome mapsHome = new MapsHome();
        String actualDistance = mapsHome.distanceToCamp();
        CustomAsserts.assertTrue("Distance to Camp is not as expected by you. Actual Distance: " +
                actualDistance, actualDistance.equals(expectedDistance));
    }
}
