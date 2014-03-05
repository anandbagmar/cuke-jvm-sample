package flows.weather;

import flows.webserviceClients.globalWeather.net.webservicex.GlobalWeather;
import flows.webserviceClients.globalWeather.net.webservicex.GlobalWeatherSoap;

public class WeatherFlow {

    private final GlobalWeatherSoap weatherService;

    public WeatherFlow() {
        GlobalWeather globalWeather = new GlobalWeather();
        this.weatherService = globalWeather.getGlobalWeatherSoap();
    }
    public String getCities(String forCountry) {
        String cities = this.weatherService.getCitiesByCountry(forCountry);
        System.out.format("Cities for " + forCountry + ": \n$" + cities);
        return cities;
    }
}
