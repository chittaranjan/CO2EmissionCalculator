import exception.InvalidApiKeyException;
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

    public double computeCO2EmissionInKg(City city1, City city2, TransportationMode transportationMode) {
        double distance = 0;
        try {
            distance = this.routeService.getDistance(city1, city2);
        } catch (InvalidApiKeyException invalidApiKeyException) {
            invalidApiKeyException.printStackTrace();
        }
        double averageCo2EmissionInGram = transportationMode.getAverageCo2Emission();
        double amountOfCo2 = (distance * averageCo2EmissionInGram)/1000;
        return amountOfCo2;
    }
}
