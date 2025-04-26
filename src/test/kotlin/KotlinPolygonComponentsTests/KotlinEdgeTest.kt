package KotlinPolygonComponentsTests

import PolygonComponents.Edge
import PolygonComponents.Point
import PolygonComponents.Polygon
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.List

class KotlinEdgeTest {

    @Test
    fun testString() {
        val pointA = Point(10, 20)
        val pointB = Point(30, 40)
        val edge = Edge(pointA, pointB)
        val expectedOutput = "Edge: $pointA, $pointB"
        Assertions.assertEquals(expectedOutput, edge.toString())
    }

    @Test
    fun testPointGetters() {
        val pointA = Point(10, 20)
        val pointB = Point(30, 40)
        val edge = Edge(pointA, pointB)
        Assertions.assertEquals(pointA, edge.getStartingPoint())
        Assertions.assertEquals(pointB, edge.getEndingPoint())
    }

    @Test
    fun testGetConnectedPoints() {
        val pointA = Point(230, 310)
        val pointB = Point(450, 120)
        val pointC = Point(570, 480)
        val pointD = Point(630, 210)

        val edgeAB = Edge(pointA, pointB)
        val edgeBC = Edge(pointB, pointC)
        val edgeCD = Edge(pointC, pointD)
        val edgeDA = Edge(pointD, pointA)

        val points = listOf<Point?>(pointA, pointB, pointC, pointD)
        val edges = listOf<Edge?>(edgeAB, edgeBC, edgeCD, edgeDA)
        val polygon = Polygon(points, edges)

        val connectedEdges = polygon.getConnectedEdges(pointB)
        val connectedPoints = Edge.getConnectedPoints(connectedEdges)
        val expectedPoints = List.of<Point?>(pointA, pointC)
        Assertions.assertEquals(expectedPoints, connectedPoints)
    }
}