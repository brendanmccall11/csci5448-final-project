import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PolygonTest {

    @Test
    public void testPolygonString() {
        Point pointA = new Point(2.3, 3.1);
        Point pointB = new Point(4.5, 1.2);
        Point pointC = new Point(5.7, 4.8);
        Point pointD = new Point(6.3, 2.1);

        Edge edgeAB = new Edge(pointA, pointB);
        Edge edgeBC = new Edge(pointB, pointC);
        Edge edgeCD = new Edge(pointC, pointD);
        Edge edgeDA = new Edge(pointD, pointA);

        Polygon polygon = new Polygon();
        polygon.addEdge(edgeAB);
        polygon.addEdge(edgeBC);
        polygon.addEdge(edgeCD);
        polygon.addEdge(edgeDA);

        StringBuilder expectedOutput = new StringBuilder("Polygon:\n");
        for (Edge edge : polygon.getEdges()) {
            expectedOutput.append(edge.toString()).append("\n");
        }
        assertEquals(expectedOutput.toString(), polygon.toString());
    }

    @Test
    public void testRemoveEdge() {
        Point pointA = new Point(2.3, 3.1);
        Point pointB = new Point(4.5, 1.2);
        Point pointC = new Point(5.7, 4.8);
        Point pointD = new Point(6.3, 2.1);

        Edge edgeAB = new Edge(pointA, pointB);
        Edge edgeBC = new Edge(pointB, pointC);
        Edge edgeCD = new Edge(pointC, pointD);
        Edge edgeDA = new Edge(pointD, pointA);

        Polygon polygon = new Polygon();
        polygon.addEdge(edgeAB);
        polygon.addEdge(edgeBC);
        polygon.addEdge(edgeCD);
        polygon.addEdge(edgeDA);

        polygon.removeEdge(edgeAB);
        List<Edge> expectedOutput = List.of(edgeBC, edgeCD, edgeDA);
        assertEquals(expectedOutput, polygon.getEdges());
    }

    @Test
    public void testGetConnectedEdges(){
        Point pointA = new Point(2.3, 3.1);
        Point pointB = new Point(4.5, 1.2);
        Point pointC = new Point(5.7, 4.8);
        Point pointD = new Point(6.3, 2.1);

        Edge edgeAB = new Edge(pointA, pointB);
        Edge edgeBC = new Edge(pointB, pointC);
        Edge edgeCD = new Edge(pointC, pointD);
        Edge edgeDA = new Edge(pointD, pointA);

        Polygon polygon = new Polygon();
        polygon.addEdge(edgeAB);
        polygon.addEdge(edgeBC);
        polygon.addEdge(edgeCD);
        polygon.addEdge(edgeDA);

        List<Edge> expectedOutput = List.of(edgeAB, edgeBC);
        assertEquals(expectedOutput, polygon.getConnectedEdges(pointB));
    }

    @Test
    public void testRemovePoint(){
        Point pointA = new Point(2.3, 3.1);
        Point pointB = new Point(4.5, 1.2);
        Point pointC = new Point(5.7, 4.8);
        Point pointD = new Point(6.3, 2.1);

        Edge edgeAB = new Edge(pointA, pointB);
        Edge edgeBC = new Edge(pointB, pointC);
        Edge edgeCD = new Edge(pointC, pointD);
        Edge edgeDA = new Edge(pointD, pointA);

        Polygon polygon = new Polygon();
        polygon.addEdge(edgeAB);
        polygon.addEdge(edgeBC);
        polygon.addEdge(edgeCD);
        polygon.addEdge(edgeDA);
        polygon.removePoint(pointB);

        Polygon expectedPolygon = new Polygon();
        Edge edgeAC = new Edge(pointA, pointC);
        expectedPolygon.addEdge(edgeCD);
        expectedPolygon.addEdge(edgeDA);
        expectedPolygon.addEdge(edgeAC);

        assertEquals(expectedPolygon.toString(), polygon.toString());
    }

}
