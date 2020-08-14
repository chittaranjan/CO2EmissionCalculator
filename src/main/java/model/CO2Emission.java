package model;

public enum CO2Emission {
    SMALL_DIESEL_CAR("small-diesel-car", 142),
    SMALL_PETROL_CAR("small-petrol-car", 154);

    public final String transportationMode;
    public final int averageCo2Emission;

    private CO2Emission(String transportationMode, int averageCo2Emission) {
        this.transportationMode = transportationMode;
        this.averageCo2Emission = averageCo2Emission;
    }

    public static CO2Emission usingTransportationMode(String transportationMode) {
        for (CO2Emission emission : values()) {
            if (emission.transportationMode.equals(transportationMode)) {
                return emission;
            }
        }
        return null;
    }
}
