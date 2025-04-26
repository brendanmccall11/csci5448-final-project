import kotlinPolygonComponents.kotlinPolygon
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class KotlinDriverTest {

    @Test
    fun testCreatePolygon() {
        val driver = KotlinDriver()
        val polygon = driver.createPolygon6Vertices()
        Assertions.assertNotNull(polygon)
        Assertions.assertEquals(kotlinPolygon::class.java, polygon.javaClass)
    }
}