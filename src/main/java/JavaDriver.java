import PolygonComponents.Edge;
import PolygonComponents.Point;
import PolygonComponents.Polygon;
import java.util.Arrays;
import java.util.List;

public class JavaDriver {

    public static void main(String[] args) {
        Polygon polygon = createPolygon();
        //polygon.draw();

        polygon.removeEdge(polygon.getEdges().get(2));
        System.out.println(polygon);
        polygon.draw();
    }

    public static Polygon createPolygon() {
        Point pointA = new Point(50, 100);
        Point pointB = new Point(100, 150);
        Point pointC = new Point(150, 100);
        Point pointD = new Point(200, 150);
        Point pointE = new Point(250, 100);
        Point pointF = new Point(200, 50);

        Edge edgeAB = new Edge(pointA, pointB);
        Edge edgeBC = new Edge(pointB, pointC);
        Edge edgeCD = new Edge(pointC, pointD);
        Edge edgeDE = new Edge(pointD, pointE);
        Edge edgeEF = new Edge(pointE, pointF);
        Edge edgeFA = new Edge(pointF, pointA);

        List<Point> points = List.of(pointA, pointB, pointC, pointD, pointE, pointF);
        List<Edge> edges = Arrays.asList(edgeAB, edgeBC, edgeCD, edgeDE, edgeEF, edgeFA);
        return new Polygon(points, edges);
    }

}
