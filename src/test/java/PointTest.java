import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointTest {

    @Test
    public void testString() {
        double xCoordinate = 10.0;
        double yCoordinate = 20.0;
        Point point = new Point(xCoordinate, yCoordinate);
        String expectedOutput = "(" + xCoordinate + ", " + yCoordinate + ")";
        assertEquals(expectedOutput, point.toString());
    }

}
