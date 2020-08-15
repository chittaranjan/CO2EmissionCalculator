import model.TransportationMode;
import org.junit.Assert;
import org.junit.Test;

public class TestTransportationMode {
    @Test
    public void testValidTransportationModes() {
        TransportationMode smallDieselCar = TransportationMode.usingTransportationMode("small-diesel-car");
        Assert.assertNotNull(smallDieselCar);
        Assert.assertEquals(142, smallDieselCar.getAverageCo2Emission());

        TransportationMode smallPetrolCar = TransportationMode.usingTransportationMode("small-petrol-car");
        Assert.assertNotNull(smallPetrolCar);
        Assert.assertEquals(154, smallPetrolCar.getAverageCo2Emission());

        TransportationMode smallPluginHybridCar = TransportationMode.usingTransportationMode("small-plugin-hybrid-car");
        Assert.assertNotNull(smallPluginHybridCar);
        Assert.assertEquals(73, smallPluginHybridCar.getAverageCo2Emission());

        TransportationMode smallElectricCar = TransportationMode.usingTransportationMode("small-electric-car");
        Assert.assertNotNull(smallElectricCar);
        Assert.assertEquals(50, smallElectricCar.getAverageCo2Emission());

        TransportationMode mediumDieselCar = TransportationMode.usingTransportationMode("medium-diesel-car");
        Assert.assertNotNull(mediumDieselCar);
        Assert.assertEquals(171, mediumDieselCar.getAverageCo2Emission());

        TransportationMode mediumPetrolCar = TransportationMode.usingTransportationMode("medium-petrol-car");
        Assert.assertNotNull(mediumPetrolCar);
        Assert.assertEquals(192, mediumPetrolCar.getAverageCo2Emission());

        TransportationMode mediumPluginHybridCar = TransportationMode.usingTransportationMode("medium-plugin-hybrid-car");
        Assert.assertNotNull(mediumPluginHybridCar);
        Assert.assertEquals(110, mediumPluginHybridCar.getAverageCo2Emission());

        TransportationMode mediumElectricCar = TransportationMode.usingTransportationMode("medium-electric-car");
        Assert.assertNotNull(mediumElectricCar);
        Assert.assertEquals(58, mediumElectricCar.getAverageCo2Emission());

        TransportationMode largeDieselCar = TransportationMode.usingTransportationMode("large-diesel-car");
        Assert.assertNotNull(largeDieselCar);
        Assert.assertEquals(209, largeDieselCar.getAverageCo2Emission());

        TransportationMode largePetrolCar = TransportationMode.usingTransportationMode("large-petrol-car");
        Assert.assertNotNull(largePetrolCar);
        Assert.assertEquals(282, largePetrolCar.getAverageCo2Emission());

        TransportationMode largePluginHybridCar = TransportationMode.usingTransportationMode("large-plugin-hybrid-car");
        Assert.assertNotNull(largePluginHybridCar);
        Assert.assertEquals(126, largePluginHybridCar.getAverageCo2Emission());

        TransportationMode largeElectricCar = TransportationMode.usingTransportationMode("large-electric-car");
        Assert.assertNotNull(largeElectricCar);
        Assert.assertEquals(73, largeElectricCar.getAverageCo2Emission());


        TransportationMode bus = TransportationMode.usingTransportationMode("bus");
        Assert.assertNotNull(bus);
        Assert.assertEquals(27, bus.getAverageCo2Emission());

        TransportationMode train = TransportationMode.usingTransportationMode("train");
        Assert.assertNotNull(train);
        Assert.assertEquals(6, train.getAverageCo2Emission());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testInvalidTransportationMode() {
        TransportationMode train = TransportationMode.usingTransportationMode("cycle");
    }
}
