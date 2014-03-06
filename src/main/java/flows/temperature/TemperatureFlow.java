package flows.temperature;

import flows.WebserviceClients.tempconvert.com.w3schools.webservices.TempConvert;
import flows.WebserviceClients.tempconvert.com.w3schools.webservices.TempConvertSoap;
import utils.CustomAsserts;
import utils.RuntimeUtils;

public class TemperatureFlow {
    private final TempConvertSoap tempService;

    public TemperatureFlow(){
        TempConvert tempConvert = new TempConvert();
        this.tempService = tempConvert.getTempConvertSoap();
    }

    public String getCelsius(String fahrenheit){
        String temperatureInCelcius = this.tempService.fahrenheitToCelsius(fahrenheit);
        RuntimeUtils.saveState("temperatureInCelsius", temperatureInCelcius);
        return temperatureInCelcius;
    }


    public void assertexpectedTemperatureninCelcius(String expectedTemperatureninCelcius) {
        CustomAsserts.assertTrue("Actual Temperature = "+RuntimeUtils.retrieveState("temperatureInCelsius"),RuntimeUtils.retrieveState("temperatureInCelsius").equals(expectedTemperatureninCelcius));
    }
}
