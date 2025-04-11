package PolygonComponentsTests;

import PolygonComponents.Edge;
import PolygonComponents.Point;
import PolygonComponents.Polygon;
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
        Point pointA = new Point(230, 310);
        Point pointB = new Point(450, 120);
        Point pointC = new Point(570, 480);
        Point pointD = new Point(630, 210);

        Edge edgeAB = new Edge(pointA, pointB);
        Edge edgeBC = new Edge(pointB, pointC);
        Edge edgeCD = new Edge(pointC, pointD);
        Edge edgeDA = new Edge(pointD, pointA);

        List<Point> points = List.of(pointA, pointB, pointC, pointD);
        List<Edge> edges = List.of(edgeAB, edgeBC, edgeCD, edgeDA);
        Polygon polygon = new Polygon(points, edges);

        List<Edge> connectedEdges = polygon.getConnectedEdges(pointB);
        List<Point> connectedPoints = Edge.getConnectedPoints(connectedEdges);
        List<Point> expectedPoints = List.of(pointA, pointC);
        assertEquals(expectedPoints, connectedPoints);
    }

}
