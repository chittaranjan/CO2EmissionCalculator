package model;

/**
 * A class represents geometry of a geo location
 */
public class Geometry {
    private GeometryType geometryType;
    private LocationModel location;

    public GeometryType getGeometryType() {
        return this.geometryType;
    }

    public LocationModel getLocation() {
        return this.location;
    }

    /**
     * Return the geo coordinate as a array of latitude and longitude
     * @return
     */
    public double[] getCoordinates() {
        return new double[] {this.location.getLatitude(), this.location.getLongitude()};
    }

    public static class Builder {
        private Geometry geometry;

        public Builder() {
            this.geometry = new Geometry();
        }

        public Builder geometryType(GeometryType geometryType) {
            this.geometry.geometryType = geometryType;
            return this;
        }

        public Builder location(LocationModel locationModel) {
            this.geometry.location = locationModel;
            return this;
        }

        public Geometry build() {
            return this.geometry;
        }
    }
}
