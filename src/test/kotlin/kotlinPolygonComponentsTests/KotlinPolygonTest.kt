package kotlinPolygonComponentsTests

import kotlinPolygonComponents.kotlinEdge
import kotlinPolygonComponents.kotlinPoint
import kotlinPolygonComponents.kotlinPolygon
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class KotlinPolygonTest {

    @Test
    fun testPolygonString() {
        val pointA = kotlinPoint(230, 310)
        val pointB = kotlinPoint(450, 120)
        val pointC = kotlinPoint(570, 480)
        val pointD = kotlinPoint(630, 210)

        val edgeAB = kotlinEdge(pointA, pointB)
        val edgeBC = kotlinEdge(pointB, pointC)
        val edgeCD = kotlinEdge(pointC, pointD)
        val edgeDA = kotlinEdge(pointD, pointA)

        val points = listOf<kotlinPoint?>(pointA, pointB, pointC, pointD)
        val edges = listOf(edgeAB, edgeBC, edgeCD, edgeDA)
        val polygon = kotlinPolygon(points as MutableList<kotlinPoint?>, edges as MutableList<kotlinEdge?>)

        val expectedOutput = StringBuilder("Polygon:\n")
        for (edge in polygon.edges) {
            expectedOutput.append(edge.toString()).append("\n")
        }
        Assertions.assertEquals(expectedOutput.toString(), polygon.toString())
    }

    @Test
    fun testRemoveEdge() {
        val pointA = kotlinPoint(230, 310)
        val pointB = kotlinPoint(450, 120)
        val pointC = kotlinPoint(630, 210)
        val pointD = kotlinPoint(570, 480)

        val edgeAB = kotlinEdge(pointA, pointB)
        val edgeBC = kotlinEdge(pointB, pointC)
        val edgeCD = kotlinEdge(pointC, pointD)
        val edgeDA = kotlinEdge(pointD, pointA)

        val points = listOf<kotlinPoint?>(pointA, pointB, pointC, pointD)
        val edges = listOf<kotlinEdge?>(edgeAB, edgeBC, edgeCD, edgeDA)
        val polygon = kotlinPolygon(points as MutableList<kotlinPoint?>, edges as MutableList<kotlinEdge?>)

        polygon.removeKotlinEdge(edgeAB)
        val expectedOutput = listOf<kotlinEdge?>(edgeBC, edgeCD, edgeDA)
        Assertions.assertEquals(expectedOutput, polygon.edges)

        Assertions.assertTrue(edgeBC.startingPoint === pointC || edgeBC.endingPoint === pointC)
        Assertions.assertTrue(edgeDA.startingPoint === pointD || edgeDA.endingPoint === pointD)

        Assertions.assertTrue((edgeBC.startingPoint === pointB || edgeBC.endingPoint === pointB) || (edgeBC.startingPoint === pointA || edgeBC.endingPoint === pointA))
        Assertions.assertTrue((edgeDA.startingPoint === pointB || edgeDA.endingPoint === pointB) || (edgeDA.startingPoint === pointA || edgeDA.endingPoint === pointA))
    }

    @Test
    fun testGetConnectedEdgesFromPoint() {
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

        val expectedOutput = listOf<kotlinEdge?>(edgeAB, edgeBC)
        Assertions.assertEquals(expectedOutput, polygon.getConnectedEdges(pointB))
    }

    @Test
    fun testGetConnectedEdgesFromEdge() {
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

        val expectedOutput = listOf<kotlinEdge?>(edgeAB, edgeCD)
        Assertions.assertEquals(expectedOutput, polygon.getConnectedEdges(edgeBC))
    }

    @Test
    fun testGetPoints() {
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

        val expectedPoints = listOf<kotlinPoint?>(pointA, pointB, pointC, pointD)
        val expectedEdges = listOf<kotlinEdge?>(edgeAB, edgeBC, edgeCD, edgeDA)
        val expectedPolygon = kotlinPolygon(expectedPoints as MutableList<kotlinPoint?>,
            expectedEdges as MutableList<kotlinEdge?>
        )

        Assertions.assertEquals(expectedPolygon.points, polygon.points)
    }

    @Test
    fun testRemovePoint() {
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
        polygon.removeKotlinPoint(pointB)

        val expectedPoints = listOf<kotlinPoint?>(pointA, pointC, pointD)
        val edgeAC = kotlinEdge(pointA, pointC)
        val expectedEdges = listOf<kotlinEdge?>(edgeCD, edgeDA, edgeAC)
        val expectedPolygon = kotlinPolygon(expectedPoints as MutableList<kotlinPoint?>,
            expectedEdges as MutableList<kotlinEdge?>
        )

        Assertions.assertEquals(expectedPolygon.toString(), polygon.toString())
    }
}