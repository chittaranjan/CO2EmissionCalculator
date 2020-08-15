import exception.InvalidApiKeyException;
import exception.InvalidCityException;
import model.TransportationMode;
import model.City;
import service.APIKeyService;
import service.APIKeyServiceImpl;
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

        APIKeyService apiKeyService = new APIKeyServiceImpl();
        if (apiKeyService.isValidApiKeyPresent() == false) {
            System.out.println("A valid API key is required. Please update the API key in config.properties");
            System.exit(0);
        }

        RouteService routeService = new RouteServiceImpl(apiKeyService);
        CO2EmissionCalculator co2EmissionCalculator = new CO2EmissionCalculator(routeService);

        try {
            double amountOfCo2 = co2EmissionCalculator.computeCO2EmissionInKg(source, destination, transportationMode);
            System.out.println("Your trip caused " + String.format("%.1f", amountOfCo2) + "kg of CO2-equivalent.");
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            System.exit(0);
        }
    }
}
