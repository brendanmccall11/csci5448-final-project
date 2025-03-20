import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EdgeTest {

    @Test
    public void testString() {
        Point pointA = new Point(10, 20);
        Point pointB = new Point(30, 40);
        Edge edge = new Edge(pointA, pointB);
        String expectedOutput = "Edge: " + pointA + ", " + pointB;
        assertEquals(expectedOutput, edge.toString());
    }

    @Test
    public void testPointGetters() {
        Point pointA = new Point(10, 20);
        Point pointB = new Point(30, 40);
        Edge edge = new Edge(pointA, pointB);
        assertEquals(pointA, edge.getStartingPoint());
        assertEquals(pointB, edge.getEndingPoint());
    }

}
