import model.City;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.RouteService;
import service.RouteServiceImpl;

/**
 * City
 * Class representing city, its geo-geometry along with BBox
 */
public class TestRouteService {

    private RouteService routeService;

    @Before
    public void setupBeforeAllTests() {
        routeService = new RouteServiceImpl();
    }

    @Test
    public void testGeoCodeValidCity() {
        City city = routeService.geoCode("Berlin");
        Assert.assertNotNull(city);
        Assert.assertNotNull(city.getGeometry());
        Assert.assertNotNull(city.getBoundingBox());
        Assert.assertEquals("Berlin", city.getName());
    }

    @Test
    public void testGeoCodeInValidCity() {
        City city = routeService.geoCode("InvalidCity");
        Assert.assertNull(city);
    }

    @Test
    public void testDistanceBetweenTwoCities() {
        City berlin = routeService.geoCode("Berlin");
        City hamburg = routeService.geoCode("Hamburg");
        Double distance = routeService.getDistance(berlin, hamburg);
        Assert.assertNotNull(distance);
        Assert.assertEquals(283.94, distance.doubleValue(), 0.0);
    }

    @Test
    public void testDistanceBetweenSameCityShouldBeZero() {
        City berlin = routeService.geoCode("Berlin");
        Double distance = routeService.getDistance(berlin, berlin);
        Assert.assertNotNull(distance);
        Assert.assertEquals(0.0, distance.doubleValue(), 0.0);
    }
}
