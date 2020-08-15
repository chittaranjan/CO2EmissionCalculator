import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.APIKeyService;
import service.APIKeyServiceImpl;
import service.RouteService;
import service.RouteServiceImpl;

public class TestCo2Calculator {

    private APIKeyService apiKeyService;
    private RouteService routeService;
    private CO2EmissionCalculator co2EmissionCalculator;

    @Before
    public void setUp() {
        apiKeyService = new APIKeyServiceImpl();
        Assert.assertTrue(apiKeyService.isValidApiKeyPresent());
        routeService = new RouteServiceImpl(apiKeyService);
        co2EmissionCalculator = new CO2EmissionCalculator(routeService);
    }

    @Test
    public void testCorrectCo2CalculationForTwoValidCitiesWithMediumDieselCarMode() throws Exception {
        String berlin = "Berlin";
        String hamburg = "Hamburg";
        String transportMode = "medium-diesel-car";
        double co2Emission = co2EmissionCalculator.computeCO2EmissionInKg(hamburg, berlin, transportMode);
        Assert.assertEquals(String.valueOf(49.2), String.format("%.1f",co2Emission));
    }

    @Test
    public void testCorrectCo2CalculationForTwoValidCitiesWithLargeElectricCar() throws Exception{
        String newYork = "New York";
        String losAngeles = "Los Angeles";
        String transportMode = "medium-diesel-car";
        double co2Emission = co2EmissionCalculator.computeCO2EmissionInKg(losAngeles, newYork, transportMode);
        Assert.assertEquals(String.valueOf(770.4), String.format("%.1f",co2Emission));
    }
}
