import java.awt.Polygon;

public class PolygonWrapper {

    public static Polygon wrap(Point[] points) {
        int numberOfPoints = points.length;
        int[] xCoordinates = new int[numberOfPoints];
        int[] yCoordinates = new int[numberOfPoints];

        for(int i = 0; i < numberOfPoints; i++){
            xCoordinates[i] = (int) points[i].getXValue();
            yCoordinates[i] = (int) points[i].getYValue();
        }
        return new Polygon(xCoordinates, yCoordinates, numberOfPoints);
    }

}
