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
    @Given("^I get list of cities$")
    public void I_get_list_of_cities() throws Throwable {
        GlobalWeather globalWeather = new GlobalWeather();
        String cities = globalWeather.getGlobalWeatherSoap().getCitiesByCountry("India");
        String weather = globalWeather.getGlobalWeatherSoap().getWeather("Pune", "India");
        System.out.println("Cities: " + cities);

        CurrencyConvertor currencyConvertor = new CurrencyConvertor();
        double rate = currencyConvertor.getCurrencyConvertorSoap().conversionRate(Currency.AUD, Currency.INR);
        System.out.println("\n\nRate: " + rate);
    }

    @When("^I get list of cities for \"(.*)\"$")
    public void I_get_list_of_cities_for_country(String forCountry) throws Throwable {
        WeatherFlow weatherFlow = new WeatherFlow();
        weatherFlow.getCities(forCountry);

    }
}
