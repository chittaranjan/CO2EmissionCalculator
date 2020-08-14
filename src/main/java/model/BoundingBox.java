package model;

public class BoundingBox {
    private LocationModel leftTop;
    private LocationModel rightBottom;

    public BoundingBox(LocationModel leftTop, LocationModel rightBottom) {
        this.leftTop = leftTop;
        this.rightBottom = rightBottom;
    }

    public LocationModel getLeftTop() {
        return leftTop;
    }

    public LocationModel getRightBottom() {
        return rightBottom;
    }
}
