import PolygonComponents.Point;
import PolygonComponents.Polygon;
import javax.swing.*;
import java.awt.*;

public class Drawer extends JPanel {

    private final PolygonComponents.Polygon polygon;

    public Drawer(PolygonComponents.Polygon polygon) {
        this.polygon = polygon;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        PolygonComponents.Point[] points = changePointsToArray(polygon);

        drawPoints(graphics, points);
        graphics.drawPolygon(PolygonWrapper.wrap((points)));
    }

    private PolygonComponents.Point[] changePointsToArray(Polygon polygon){
        PolygonComponents.Point[] points = new PolygonComponents.Point[polygon.getPoints().size()];
        for(int i = 0; i < polygon.getPoints().size(); i++) {
            points[i] = polygon.getPoints().get(i);
        }
        return points;
    }

    private void drawPoints(Graphics graphics, PolygonComponents.Point[] points){
        graphics.setColor(Color.BLUE);
        for (PolygonComponents.Point point : points) {
            drawPoint(graphics, point);
        }
    }

    private void drawPoint(Graphics graphics, Point point){
        int xCoordinate = point.getXValue();
        int yCoordinate = point.getYValue();
        int RADIUS_OF_POINT = 7;
        int DIAMETER = 2 * RADIUS_OF_POINT;
        graphics.fillOval(xCoordinate - RADIUS_OF_POINT, yCoordinate - RADIUS_OF_POINT, DIAMETER, DIAMETER);

    }
}
