package flows.weather;

import com.jayway.jsonpath.JsonPath;
import flows.webserviceClients.globalWeather.net.webservicex.GlobalWeather;
import flows.webserviceClients.globalWeather.net.webservicex.GlobalWeatherSoap;
import utils.FileUtils;
import utils.RuntimeUtils;

import java.util.List;

public class WeatherFlow {

    private final GlobalWeatherSoap weatherService;

    public WeatherFlow() {
        GlobalWeather globalWeather = new GlobalWeather();
        this.weatherService = globalWeather.getGlobalWeatherSoap();
    }

    public List<String> getCities(String forCountry) {
        String citiesByCountry = this.weatherService.getCitiesByCountry(forCountry);
        String jsonString = FileUtils.convertStringToJsonString(citiesByCountry);
        List<String> listOfCities = JsonPath.read(jsonString, "$.NewDataSet.Table[*].City");
        System.out.println("\tNumber of Cities: " + listOfCities.size());
        RuntimeUtils.saveState("listOfCitiesFor" + forCountry, listOfCities);
        return listOfCities;
    }

    public void getWeatherForCities(int numberOfCities, String forCountry) {
        List<String> listOfCities = (List<String>) RuntimeUtils.retrieveState("listOfCitiesFor" + forCountry);
        for(int cityNumber=0; cityNumber<numberOfCities; cityNumber++) {
            String cityName = listOfCities.get(cityNumber);
            String weather = this.weatherService.getWeather(cityName, forCountry);
            System.out.println ("\n\tWeather for city: " + cityName + "::" + forCountry + ": " + weather);
        }
    }
}
