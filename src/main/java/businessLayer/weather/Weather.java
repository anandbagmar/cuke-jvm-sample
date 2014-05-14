package businessLayer.weather;

import businessLayer.Base;
import com.jayway.jsonpath.JsonPath;
import businessLayer.webserviceClients.globalWeather.GlobalWeather;
import businessLayer.webserviceClients.globalWeather.GlobalWeatherSoap;
import utils.FileUtils;
import utils.RuntimeUtils;

import java.util.List;

public class Weather extends Base {

    private final GlobalWeatherSoap weatherService;

    public Weather() {
        GlobalWeather globalWeather = new GlobalWeather();
        this.weatherService = globalWeather.getGlobalWeatherSoap();
    }

    public List<String> getCities(String forCountry) {
        String citiesByCountry = this.weatherService.getCitiesByCountry(forCountry);
        String jsonString = FileUtils.convertStringToJsonString(citiesByCountry);
        List<String> listOfCities = JsonPath.read(jsonString, "$.NewDataSet.Table[*].City");
        logger.info("\tNumber of Cities: " + listOfCities.size());
        RuntimeUtils.saveState("listOfCitiesFor" + forCountry, listOfCities);
        return listOfCities;
    }

    public void getWeatherForCities(int numberOfCities, String forCountry) {
        List<String> listOfCities = (List<String>) RuntimeUtils.retrieveState("listOfCitiesFor" + forCountry);
        for(int cityNumber=0; cityNumber<numberOfCities; cityNumber++) {
            String cityName = listOfCities.get(cityNumber);
            String weather = this.weatherService.getWeather(cityName, forCountry);
            logger.info("\n\tWeather for city: " + cityName + "::" + forCountry + ": " + weather);
        }
    }
}
