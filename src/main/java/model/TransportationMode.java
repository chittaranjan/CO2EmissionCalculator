package model;

/**
 * Transportation methods in CO2e per passenger per km
 */
public enum TransportationMode {
    /* Small Cars */
    SMALL_DIESEL_CAR("small-diesel-car", 142),
    SMALL_PETROL_CAR("small-petrol-car", 154),
    SMALL_PLUGIN_HYBRID_CAR("small-plugin-hybrid-car", 73),
    SMALL_ELECTRIC_CAR("small-electric-car", 50),

    /* Medium Cars*/
    MEDIUM_DIESEL_CAR("medium-diesel-car", 171),
    MEDIUM_PETROL_CAR("medium-petrol-car", 192),
    MEDIUM_PLUGIN_HYBRID_CAR("medium-plugin-hybrid-car", 110),
    MEDIUM_ELECTRIC_CAR("medium-electric-car", 58),

    /* Large Cars */
    LARGE_DIESEL_CAR("large-diesel-car", 209),
    LARGE_PETROL_CAR("large-petrol-car", 282),
    LARGE_PLUGIN_HYBRID_CAR("large-plugin-hybrid-car", 126),
    LARGE_ELECTRIC_CAR("large-electric-car", 73),

    // Bus
    BUS("bus", 27),
    //Train

    TRAIN("train", 6);


    private final String transportationMode;
    private final int averageCo2Emission;

    TransportationMode(String transportationMode, int averageCo2Emission) {
        this.transportationMode = transportationMode;
        this.averageCo2Emission = averageCo2Emission;
    }

    public int getAverageCo2Emission() {
        return averageCo2Emission;
    }

    public static TransportationMode usingTransportationMode(String transportationMode) {
        for (TransportationMode emission : values()) {
            if (emission.transportationMode.equals(transportationMode)) {
                return emission;
            }
        }
        throw new IllegalArgumentException("Provided transportation mode "+ transportationMode + " is not supported.");
    }
}
