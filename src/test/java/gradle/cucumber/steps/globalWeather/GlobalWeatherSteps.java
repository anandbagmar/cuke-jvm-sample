package gradle.cucumber.steps.globalWeather;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import flows.weather.WeatherFlow;
import flows.webserviceClients.currencyConvertor.net.webservicex.Currency;
import flows.webserviceClients.currencyConvertor.net.webservicex.CurrencyConvertor;
import flows.webserviceClients.globalWeather.net.webservicex.GlobalWeather;

import javax.xml.namespace.QName;
import java.net.URL;

public class GlobalWeatherSteps {
    @When("^I get list of cities for \"(.*)\"$")
    public void I_get_list_of_cities_for_country(String forCountry) throws Throwable {
        WeatherFlow weatherFlow = new WeatherFlow();
        weatherFlow.getCities(forCountry);
    }
}
