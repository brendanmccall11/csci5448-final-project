import javax.swing.*;
import java.awt.*;

public class Drawer extends JPanel {

    private final Polygon polygon;

    public Drawer(Polygon polygon) {
        this.polygon = polygon;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Point[] points = changePointsToArray(polygon);

        drawPoints(graphics, points);
        graphics.drawPolygon(PolygonWrapper.wrap((points)));
    }

    private Point[] changePointsToArray(Polygon polygon){
        Point[] points = new Point[polygon.getPoints().size()];
        for(int i = 0; i < polygon.getPoints().size(); i++) {
            points[i] = polygon.getPoints().get(i);
        }
        return points;
    }

    private void drawPoints(Graphics graphics, Point[] points){
        graphics.setColor(Color.BLUE);
        for (Point point : points) {
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
