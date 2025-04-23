import PolygonComponents.Polygon;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JavaDriverTest {

    @Test
    public void testCreatePolygon() {
        Polygon polygon = JavaDriver.createPolygon6Vertices();
        assertNotNull(polygon);
        assertEquals(Polygon.class, polygon.getClass());
    }

}
