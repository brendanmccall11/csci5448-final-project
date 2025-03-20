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
        Point pointE = new Point(7.1, 5.5);
        Point pointF = new Point(8.2, 3.7);
        Point pointG = new Point(9.4, 6.0);
        Point pointH = new Point(3.8, 6.4);
        Point pointI = new Point(2.1, 7.2);
        Point pointJ = new Point(1.4, 5.0);

        Edge edgeAB = new Edge(pointA, pointB);
        Edge edgeBC = new Edge(pointB, pointC);
        Edge edgeCD = new Edge(pointC, pointD);
        Edge edgeDE = new Edge(pointD, pointE);
        Edge edgeEF = new Edge(pointE, pointF);
        Edge edgeGF = new Edge(pointF, pointG);
        Edge edgeHF = new Edge(pointG, pointH);
        Edge edgeIH = new Edge(pointH, pointI);
        Edge edgeJH = new Edge(pointI, pointJ);
        Edge edgeJA = new Edge(pointJ, pointA);

        Polygon polygon = new Polygon();
        polygon.addEdge(edgeAB);
        polygon.addEdge(edgeBC);
        polygon.addEdge(edgeCD);
        polygon.addEdge(edgeDE);
        polygon.addEdge(edgeEF);
        polygon.addEdge(edgeGF);
        polygon.addEdge(edgeHF);
        polygon.addEdge(edgeIH);
        polygon.addEdge(edgeJH);
        polygon.addEdge(edgeJA);

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

}
