package model;

public enum GeometryType {
    Point("Point"),
    Circle("Circle"),
    Rectangle("Rectangle");

    private String name;
    GeometryType(String name) {
        this.name = name;
    }
}
