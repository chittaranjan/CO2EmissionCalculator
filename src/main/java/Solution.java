import model.CO2Emission;
import model.City;
import model.Profile;
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

        RouteService routeService = new RouteServiceImpl();

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
        double distance = routeService.getDistance(city1, city2, Profile.DRIVING_CAR);
        double averageCo2Emission = CO2Emission.usingTransportationMode(transportationMode).averageCo2Emission;
        double amountOfCo2 = distance * averageCo2Emission;

        System.out.println("Your trip caused " + amountOfCo2 + "kg of CO2-equivalent.");

    }
}
