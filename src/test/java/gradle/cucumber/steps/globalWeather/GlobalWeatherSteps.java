package gradle.cucumber.steps.globalWeather;

import businessLayer.weather.Weather;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GlobalWeatherSteps {
    @When("^I get list of cities for \"(.*)\"$")
    public void I_get_list_of_cities_for_country(String forCountry) throws Throwable {
        Weather weather = new Weather();
        weather.getCities(forCountry);
    }

    @Then("^I can see the weather for (\\d+) random cities in \"([^\"]*)\"$")
    public void I_can_see_the_weather_for_random_cities_in(int numberOfCities, String forCountry) throws Throwable {
        Weather weather = new Weather();
        weather.getWeatherForCities(numberOfCities, forCountry);
    }
}
