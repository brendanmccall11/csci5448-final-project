import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EdgeTest {

    @Test
    public void testString() {
        Point pointA = new Point(10, 20);
        Point pointB = new Point(30, 40);
        Edge edge = new Edge(pointA, pointB);
        String expectedOutput = "Edge: " + pointA + ", " + pointB;
        assertEquals(expectedOutput, edge.toString());
    }

    @Test
    public void testPointGetters() {
        Point pointA = new Point(10, 20);
        Point pointB = new Point(30, 40);
        Edge edge = new Edge(pointA, pointB);
        assertEquals(pointA, edge.getStartingPoint());
        assertEquals(pointB, edge.getEndingPoint());
    }

    @Test
    public void testGetConnectedPoints() {
        Point pointA = new Point(2.3, 3.1);
        Point pointB = new Point(4.5, 1.2);
        Point pointC = new Point(5.7, 4.8);
        Point pointD = new Point(6.3, 2.1);

        Edge edgeAB = new Edge(pointA, pointB);
        Edge edgeBC = new Edge(pointB, pointC);
        Edge edgeCD = new Edge(pointC, pointD);
        Edge edgeDA = new Edge(pointD, pointA);

        List<Edge> edges = List.of(edgeAB, edgeBC, edgeCD, edgeDA);
        Polygon polygon = new Polygon(edges);

        List<Edge> connectedEdges = polygon.getConnectedEdges(pointB);
        List<Point> connectedPoints = Edge.getConnectedPoints(connectedEdges);
        List<Point> expectedPoints = List.of(pointA, pointC);
        assertEquals(expectedPoints, connectedPoints);
    }

}
