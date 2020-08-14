package model;

public class City {
    private String name;
    private Geometry geometry;
    private BoundingBox boundingBox;

    public String getName() {
        return name;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public BoundingBox getBoundingBox() {
        return boundingBox;
    }

    //Builder class
    public static class Builder {
        private City city;

        public Builder() {
            city = new City();
        }

        public Builder name(String name) {
            city.name = name;
            return this;
        }

        public Builder geometry(Geometry geometry) {
            city.geometry = geometry;
            return this;
        }

        public Builder boundingBox(BoundingBox boundingBox) {
            city.boundingBox = boundingBox;
            return this;
        }

        public City build() {
            return this.city;
        }
    }
}
