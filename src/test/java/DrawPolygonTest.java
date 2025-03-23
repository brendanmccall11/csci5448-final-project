
import PolygonComponents.Polygon;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DrawPolygonTest {

    @Test
    public void testPolygonDrawn() {
        Polygon polygon = JavaDriver.createPolygon();
        DrawPolygon drawPolygon = new DrawPolygon(polygon);
        drawPolygon.draw();
        assertNotNull(drawPolygon);
    }

}
