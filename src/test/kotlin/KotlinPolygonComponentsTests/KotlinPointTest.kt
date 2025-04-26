package KotlinPolygonComponentsTests

import PolygonComponents.Point
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class KotlinPointTest {

    @Test
    fun testString() {
        val xCoordinate = 10
        val yCoordinate = 20
        val point = Point(xCoordinate, yCoordinate)
        val expectedOutput = "($xCoordinate, $yCoordinate)"
        Assertions.assertEquals(expectedOutput, point.toString())
    }
}