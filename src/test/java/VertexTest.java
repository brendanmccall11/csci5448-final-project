import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VertexTest {

    @Test
    public void testString() {
        int xCoordinate = 10;
        int yCoordinate = 20;
        Vertex vertex = new Vertex(xCoordinate, yCoordinate);
        String vertexString = "(" + xCoordinate + ", " + yCoordinate + ")";
        assertEquals(vertexString, vertex.toString());
    }

}
