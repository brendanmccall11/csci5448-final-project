import javax.swing.*;
import java.awt.*;

public class Drawer extends JPanel {

    private final Polygon polygon;
    private final int RADIUS_OF_POINT = 7;
    private final int DIAMETER = 2 * RADIUS_OF_POINT;

    public Drawer(Polygon polygon) {
        this.polygon = polygon;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

//        graphics.setColor(Color.BLACK);
//        graphics.drawRect(100, 100, 50, 200);

        graphics.setColor(Color.BLUE);
        int xCoordinate = 100;
        int yCoordinate = 100;
        graphics.fillOval(xCoordinate - RADIUS_OF_POINT, yCoordinate - RADIUS_OF_POINT, DIAMETER, DIAMETER);

        //graphics.drawPolygon(polygon);



    }

//    private Polygon polygonWrapper(){
//        int[] xCoordinates = new int[0];
//        int[] yCoordinates = new int[0];
//
//
//
//    }






}
