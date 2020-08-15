import model.TransportationMode;
import model.City;
import service.RouteService;

public class CO2EmissionCalculator {
    private RouteService routeService;

    public CO2EmissionCalculator(RouteService routeService) {
        this.routeService = routeService;
    }

    public double computeCO2EmissionInKg(City city1, City city2, TransportationMode transportationMode) {
        double distance = this.routeService.getDistance(city1, city2);
        double averageCo2EmissionInGram = transportationMode.getAverageCo2Emission();
        double amountOfCo2 = (distance * averageCo2EmissionInGram)/1000;
        return amountOfCo2;
    }
}
