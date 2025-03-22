import java.util.Arrays;
import java.util.List;

public class JavaMain {

    public static void main(String[] args) {

        Point pointA = new Point(2.3, 3.1);
        Point pointB = new Point(4.5, 1.2);
        Point pointC = new Point(5.7, 4.8);
        Point pointD = new Point(6.3, 2.1);

        Edge edgeAB = new Edge(pointA, pointB);
        Edge edgeBC = new Edge(pointB, pointC);
        Edge edgeCD = new Edge(pointC, pointD);
        Edge edgeDA = new Edge(pointD, pointA);

        List<Point> points = List.of(pointA, pointB, pointC, pointD);
        List<Edge> edges = Arrays.asList(edgeAB, edgeBC, edgeCD, edgeDA);
        Polygon polygon = new Polygon(points, edges);

        PolygonOutput polygonOutput = new PolygonOutput(polygon);
        polygonOutput.draw();

    }

}
