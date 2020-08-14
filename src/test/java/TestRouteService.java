import model.City;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.RouteService;
import service.RouteServiceImpl;

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
}
