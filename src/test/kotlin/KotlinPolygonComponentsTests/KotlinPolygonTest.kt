package KotlinPolygonComponentsTests

import PolygonComponents.Edge
import PolygonComponents.Point
import PolygonComponents.Polygon
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*
import java.util.List

class KotlinPolygonTest {

    @Test
    fun testPolygonString() {
        val pointA = Point(230, 310)
        val pointB = Point(450, 120)
        val pointC = Point(570, 480)
        val pointD = Point(630, 210)

        val edgeAB = Edge(pointA, pointB)
        val edgeBC = Edge(pointB, pointC)
        val edgeCD = Edge(pointC, pointD)
        val edgeDA = Edge(pointD, pointA)

        val points = listOf<Point?>(pointA, pointB, pointC, pointD)
        val edges = listOf(edgeAB, edgeBC, edgeCD, edgeDA)
        val polygon = Polygon(points, edges)

        val expectedOutput = StringBuilder("Polygon:\n")
        for (edge in polygon.edges) {
            expectedOutput.append(edge.toString()).append("\n")
        }
        Assertions.assertEquals(expectedOutput.toString(), polygon.toString())
    }

    @Test
    fun testRemoveEdge() {
        val pointA = Point(230, 310)
        val pointB = Point(450, 120)
        val pointC = Point(630, 210)
        val pointD = Point(570, 480)

        val edgeAB = Edge(pointA, pointB)
        val edgeBC = Edge(pointB, pointC)
        val edgeCD = Edge(pointC, pointD)
        val edgeDA = Edge(pointD, pointA)

        val points = List.of<Point?>(pointA, pointB, pointC, pointD)
        val edges = Arrays.asList<Edge?>(edgeAB, edgeBC, edgeCD, edgeDA)
        val polygon = Polygon(points, edges)

        polygon.removeEdge(edgeAB)
        val expectedOutput = List.of<Edge?>(edgeBC, edgeCD, edgeDA)
        Assertions.assertEquals(expectedOutput, polygon.getEdges())

        Assertions.assertTrue(edgeBC.getStartingPoint() === pointC || edgeBC.getEndingPoint() === pointC)
        Assertions.assertTrue(edgeDA.getStartingPoint() === pointD || edgeDA.getEndingPoint() === pointD)

        Assertions.assertTrue((edgeBC.getStartingPoint() === pointB || edgeBC.getEndingPoint() === pointB) || (edgeBC.getStartingPoint() === pointA || edgeBC.getEndingPoint() === pointA))
        Assertions.assertTrue((edgeDA.getStartingPoint() === pointB || edgeDA.getEndingPoint() === pointB) || (edgeDA.getStartingPoint() === pointA || edgeDA.getEndingPoint() === pointA))
    }

    @Test
    fun testGetConnectedEdgesFromPoint() {
        val pointA = Point(230, 310)
        val pointB = Point(450, 120)
        val pointC = Point(570, 480)
        val pointD = Point(630, 210)

        val edgeAB = Edge(pointA, pointB)
        val edgeBC = Edge(pointB, pointC)
        val edgeCD = Edge(pointC, pointD)
        val edgeDA = Edge(pointD, pointA)

        val points = List.of<Point?>(pointA, pointB, pointC, pointD)
        val edges = Arrays.asList<Edge?>(edgeAB, edgeBC, edgeCD, edgeDA)
        val polygon = Polygon(points, edges)

        val expectedOutput = List.of<Edge?>(edgeAB, edgeBC)
        Assertions.assertEquals(expectedOutput, polygon.getConnectedEdges(pointB))
    }

    @Test
    fun testGetConnectedEdgesFromEdge() {
        val pointA = Point(230, 310)
        val pointB = Point(450, 120)
        val pointC = Point(570, 480)
        val pointD = Point(630, 210)

        val edgeAB = Edge(pointA, pointB)
        val edgeBC = Edge(pointB, pointC)
        val edgeCD = Edge(pointC, pointD)
        val edgeDA = Edge(pointD, pointA)

        val points = List.of<Point?>(pointA, pointB, pointC, pointD)
        val edges = Arrays.asList<Edge?>(edgeAB, edgeBC, edgeCD, edgeDA)
        val polygon = Polygon(points, edges)

        val expectedOutput = List.of<Edge?>(edgeAB, edgeCD)
        Assertions.assertEquals(expectedOutput, polygon.getConnectedEdges(edgeBC))
    }

    @Test
    fun testGetPoints() {
        val pointA = Point(230, 310)
        val pointB = Point(450, 120)
        val pointC = Point(570, 480)
        val pointD = Point(630, 210)

        val edgeAB = Edge(pointA, pointB)
        val edgeBC = Edge(pointB, pointC)
        val edgeCD = Edge(pointC, pointD)
        val edgeDA = Edge(pointD, pointA)

        val points = List.of<Point?>(pointA, pointB, pointC, pointD)
        val edges = Arrays.asList<Edge?>(edgeAB, edgeBC, edgeCD, edgeDA)
        val polygon = Polygon(points, edges)

        val expectedPoints = List.of<Point?>(pointA, pointB, pointC, pointD)
        val expectedEdges = Arrays.asList<Edge?>(edgeAB, edgeBC, edgeCD, edgeDA)
        val expectedPolygon = Polygon(expectedPoints, expectedEdges)

        Assertions.assertEquals(expectedPolygon.getPoints(), polygon.getPoints())
    }

    @Test
    fun testRemovePoint() {
        val pointA = Point(230, 310)
        val pointB = Point(450, 120)
        val pointC = Point(570, 480)
        val pointD = Point(630, 210)

        val edgeAB = Edge(pointA, pointB)
        val edgeBC = Edge(pointB, pointC)
        val edgeCD = Edge(pointC, pointD)
        val edgeDA = Edge(pointD, pointA)

        val points = List.of<Point?>(pointA, pointB, pointC, pointD)
        val edges = Arrays.asList<Edge?>(edgeAB, edgeBC, edgeCD, edgeDA)
        val polygon = Polygon(points, edges)
        polygon.removePoint(pointB)

        val expectedPoints = List.of<Point?>(pointA, pointC, pointD)
        val edgeAC = Edge(pointA, pointC)
        val expectedEdges = Arrays.asList<Edge?>(edgeCD, edgeDA, edgeAC)
        val expectedPolygon = Polygon(expectedPoints, expectedEdges)

        Assertions.assertEquals(expectedPolygon.toString(), polygon.toString())
    }
}