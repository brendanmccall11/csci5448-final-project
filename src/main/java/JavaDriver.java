import PolygonComponents.Edge;
import PolygonComponents.Point;
import PolygonComponents.Polygon;
import java.util.Arrays;
import java.util.List;

public class JavaDriver {

    public static void main(String[] args) {
        Point pointA = new Point(230, 310);
        Point pointB = new Point(450, 120);
        Point pointC = new Point(570, 480);
        Point pointD = new Point(630, 210);

        Edge edgeAB = new Edge(pointA, pointB);
        Edge edgeBC = new Edge(pointB, pointC);
        Edge edgeCD = new Edge(pointC, pointD);
        Edge edgeDA = new Edge(pointD, pointA);

        List<Point> points = List.of(pointA, pointB, pointC, pointD);
        List<Edge> edges = Arrays.asList(edgeAB, edgeBC, edgeCD, edgeDA);
        Polygon polygon = new Polygon(points, edges);

        DrawPolygon drawPolygon = new DrawPolygon(polygon);
        drawPolygon.draw();
    }

}
