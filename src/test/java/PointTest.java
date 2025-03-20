import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointTest {

    @Test
    public void testString() {
        int xCoordinate = 10;
        int yCoordinate = 20;
        Point point = new Point(xCoordinate, yCoordinate);
        String vertexString = "(" + xCoordinate + ", " + yCoordinate + ")";
        assertEquals(vertexString, point.toString());
    }

}
