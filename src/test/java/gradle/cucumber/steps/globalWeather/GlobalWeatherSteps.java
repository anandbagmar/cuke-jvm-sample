package gradle.cucumber.steps.globalWeather;

import cucumber.api.java.en.When;
import flows.weather.WeatherFlow;

public class GlobalWeatherSteps {
    @When("^I get list of cities for \"(.*)\"$")
    public void I_get_list_of_cities_for_country(String forCountry) throws Throwable {
        WeatherFlow weatherFlow = new WeatherFlow();
        weatherFlow.getCities(forCountry);
    }
}
