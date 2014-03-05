package flows.weather;

import utils.RuntimeUtils;
import flows.webserviceClients.globalWeather.net.webservices.GlobalWeather;
import flows.webserviceClients.globalWeather.net.webservices.GlobalWeatherSoap;

import javax.xml.ws.BindingProvider;
import java.util.Map;
import com.jayway.jsonpath.JsonPath;
import utils.FileUtils;
import utils.RuntimeUtils;

import java.util.List;

public class WeatherFlow {

    private GlobalWeatherSoap weatherService;

    public WeatherFlow() {
        GlobalWeather globalWeather = new GlobalWeather();
        this.weatherService = globalWeather.getGlobalWeatherSoap();
        setUrl("http://www.webservicex.com/globalweather.asmx"); //TODO: Set actual URL from prop file since URLs are initially hard-coded in generated files
    }

    private void setUrl(String url) {
        BindingProvider bindingProvider = (BindingProvider) this.weatherService;
        Map<String,Object> requestContext = bindingProvider.getRequestContext();
        requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);
        /*
        SET UID/PWD if required from prop file

        requestContext.put(BindingProvider.USERNAME_PROPERTY, "someUser");
        requestContext.put(BindingProvider.PASSWORD_PROPERTY, "somePass");
         */

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
