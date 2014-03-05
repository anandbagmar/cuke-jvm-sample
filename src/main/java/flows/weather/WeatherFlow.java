package flows.weather;


import flows.webserviceClients.globalWeather.net.webservices.GlobalWeather;
import flows.webserviceClients.globalWeather.net.webservices.GlobalWeatherSoap;

import javax.xml.ws.BindingProvider;
import java.util.Map;

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

    public String getCities(String forCountry) {
        String cities = this.weatherService.getCitiesByCountry(forCountry);
        System.out.format("Cities for " + forCountry + ": \n$" + cities);
        return cities;
    }
}
