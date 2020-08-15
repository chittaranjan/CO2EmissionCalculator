import model.TransportationMode;
import model.City;
import service.RouteService;
import service.RouteServiceImpl;

public class Solution {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Please provide correct arguments e.g. source city, destination city and transportation mode");
            System.exit(0);
        }
        String source = args[0];
        String destination = args[1];
        String transportationMode = args[2];

        //Inject RouteService to the calculator
        RouteService routeService = new RouteServiceImpl();
        CO2EmissionCalculator co2EmissionCalculator = new CO2EmissionCalculator(routeService);

        City city1 = routeService.geoCode(source);
        if (city1 == null) {
            System.out.println("Unable to geocode city with name " + source);
            System.exit(0);
        }
        City city2 = routeService.geoCode(destination);
        if (city2 == null) {
            System.out.println("Unable to geocode city with name " + destination);
            System.exit(0);
        }

        TransportationMode usingTransportationMode = null;
        try {
            usingTransportationMode = TransportationMode.usingTransportationMode(transportationMode);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getLocalizedMessage());
            System.exit(0);
        }
        double amountOfCo2 = co2EmissionCalculator.computeCO2EmissionInKg(city1, city2, usingTransportationMode);
        System.out.println("Your trip caused " + String.format("%.1f", amountOfCo2) + "kg of CO2-equivalent.");
    }
}
