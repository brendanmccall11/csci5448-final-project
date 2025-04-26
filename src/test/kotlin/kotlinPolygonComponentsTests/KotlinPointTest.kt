package kotlinPolygonComponentsTests

import kotlinPolygonComponents.kotlinPoint
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class KotlinPointTest {

    @Test
    fun testString() {
        val xCoordinate = 10
        val yCoordinate = 20
        val point = kotlinPoint(xCoordinate, yCoordinate)
        val expectedOutput = "($xCoordinate, $yCoordinate)"
        Assertions.assertEquals(expectedOutput, point.toString())
    }
}