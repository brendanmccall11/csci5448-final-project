import PolygonComponents.Edge;
import PolygonComponents.Point;
import PolygonComponents.Polygon;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DrawPolygonTest {

    @Test
    public void testPolygonDrawn() {
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

        DrawPolygon drawPolygon = new DrawPolygon(polygon);
        drawPolygon.draw();
        assertNotNull(drawPolygon);
    }

}
