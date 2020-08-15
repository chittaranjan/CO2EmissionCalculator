import exception.InvalidApiKeyException;
import exception.InvalidCityException;
import model.TransportationMode;
import model.City;
import service.RouteService;

/**
 * CO2EmissionCalculator
 * This is the main class to initiate the computation of CO2e for transportation between 2 cities
 */
public class CO2EmissionCalculator {
    private RouteService routeService;

    public CO2EmissionCalculator(RouteService routeService) {
        this.routeService = routeService;
    }

    public double computeCO2EmissionInKg(String startCity, String endCity, String transportationMode)
            throws Exception {
        City geoCodedStartCity = routeService.geoCode(startCity);
        if (geoCodedStartCity == null) {
            throw new InvalidCityException(startCity);
        }

        City geoCodedEndCity = routeService.geoCode(endCity);
        if (geoCodedEndCity == null) {
            throw new InvalidCityException(startCity);
        }

        //Compute distance
        double distance = this.routeService.getDistance(geoCodedStartCity, geoCodedEndCity);

        //Fetch the CO2 for the given trabsportation mode
        TransportationMode usingTransportationMode = TransportationMode.usingTransportationMode(transportationMode);
        double averageCo2EmissionInGram = usingTransportationMode.getAverageCo2Emission();

        //Calculate the amount of CO2e in Kg and return
        double amountOfCo2 = (distance * averageCo2EmissionInGram)/1000;
        return amountOfCo2;
    }
}
