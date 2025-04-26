package KotlinPolygonComponentsTests

import kotlinPolygonComponents.kotlinPoint
import kotlinPolygonComponents.kotlinEdge
import kotlinPolygonComponents.kotlinPolygon
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.List

class KotlinEdgeTest {

    @Test
    fun testString() {
        val pointA = kotlinPoint(10, 20)
        val pointB = kotlinPoint(30, 40)
        val edge = kotlinEdge(pointA, pointB)
        val expectedOutput = "Edge: $pointA, $pointB"
        Assertions.assertEquals(expectedOutput, edge.toString())
    }

    @Test
    fun testPointGetters() {
        val pointA = kotlinPoint(10, 20)
        val pointB = kotlinPoint(30, 40)
        val edge = kotlinEdge(pointA, pointB)
        Assertions.assertEquals(pointA, edge.startingPoint)
        Assertions.assertEquals(pointB, edge.endingPoint)
    }

    @Test
    fun testGetConnectedPoints() {
        val pointA = kotlinPoint(230, 310)
        val pointB = kotlinPoint(450, 120)
        val pointC = kotlinPoint(570, 480)
        val pointD = kotlinPoint(630, 210)

        val edgeAB = kotlinEdge(pointA, pointB)
        val edgeBC = kotlinEdge(pointB, pointC)
        val edgeCD = kotlinEdge(pointC, pointD)
        val edgeDA = kotlinEdge(pointD, pointA)

        val points = listOf<kotlinPoint?>(pointA, pointB, pointC, pointD)
        val edges = listOf<kotlinEdge?>(edgeAB, edgeBC, edgeCD, edgeDA)
        val polygon = kotlinPolygon(points as MutableList<kotlinPoint?>, edges as MutableList<kotlinEdge?>)

        val connectedEdges = polygon.getConnectedEdges(pointB)
        val connectedPoints = kotlinEdge.getConnectedPoints(connectedEdges)
        val expectedPoints = List.of<kotlinPoint?>(pointA, pointC)
        Assertions.assertEquals(expectedPoints, connectedPoints)
    }
}