
import PolygonComponents.Polygon;
import javax.swing.*;

public class DrawPolygon {

    private final Polygon polygon;

    DrawPolygon(Polygon polygon) {
        this.polygon = polygon;
    }

    public void draw(){
        Drawer drawPolygon = new Drawer(polygon);
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(drawPolygon);

        frame.setSize(500, 500);
        frame.setVisible(true);
    }

}
