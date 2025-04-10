import PolygonComponents.Edge;
import PolygonComponents.Point;
import PolygonComponents.Polygon;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PolygonTest {

    @Test
    public void testPolygonString() {
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

        StringBuilder expectedOutput = new StringBuilder("PolygonComponents.Polygon:\n");
        for (Edge edge : polygon.getEdges()) {
            expectedOutput.append(edge.toString()).append("\n");
        }
        assertEquals(expectedOutput.toString(), polygon.toString());
    }

    @Test
    public void testRemoveEdge() {
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

        polygon.removeEdge(edgeAB);
        List<Edge> expectedOutput = List.of(edgeBC, edgeCD, edgeDA);
        assertEquals(expectedOutput, polygon.getEdges());
    }
//
//    @Test
//    public void testGetConnectedEdges(){
//        Point pointA = new Point(230, 310);
//        Point pointB = new Point(450, 120);
//        Point pointC = new Point(570, 480);
//        Point pointD = new Point(630, 210);
//
//        Edge edgeAB = new Edge(pointA, pointB);
//        Edge edgeBC = new Edge(pointB, pointC);
//        Edge edgeCD = new Edge(pointC, pointD);
//        Edge edgeDA = new Edge(pointD, pointA);
//
//        List<Point> points = List.of(pointA, pointB, pointC, pointD);
//        List<Edge> edges = Arrays.asList(edgeAB, edgeBC, edgeCD, edgeDA);
//        Polygon polygon = new Polygon(points, edges);
//
//        List<Edge> expectedOutput = List.of(edgeAB, edgeBC);
//        assertEquals(expectedOutput, polygon.getConnectedEdges(pointB));
//    }

    @Test
    public void testGetConnectedEdges(){
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

        List<Edge> expectedOutput = List.of(edgeAB, edgeCD);
        assertEquals(expectedOutput, polygon.getConnectedEdges(edgeBC));
    }

    @Test
    public void testGetPoints(){
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

        List<Point> expectedPoints = List.of(pointA, pointB, pointC, pointD);
        List<Edge> expectedEdges = Arrays.asList(edgeAB, edgeBC, edgeCD, edgeDA);
        Polygon expectedPolygon = new Polygon(expectedPoints, expectedEdges);

        assertEquals(expectedPolygon.getPoints(), polygon.getPoints());
    }

    @Test
    public void testRemovePoint(){
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
        polygon.removePoint(pointB);

        List<Point> expectedPoints = List.of(pointA, pointC, pointD);
        Edge edgeAC = new Edge(pointA, pointC);
        List<Edge> expectedEdges = Arrays.asList(edgeCD, edgeDA, edgeAC);
        Polygon expectedPolygon = new Polygon(expectedPoints, expectedEdges);

        assertEquals(expectedPolygon.toString(), polygon.toString());
    }

}
