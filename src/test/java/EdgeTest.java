import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EdgeTest {

    @Test
    public void testString() {
        Vertex vertexA = new Vertex(10, 20);
        Vertex vertexB = new Vertex(30, 40);
        Edge edge = new Edge(vertexA, vertexB);
        String edgeString = "Edge: " + vertexA + ", " + vertexB;
        assertEquals(edgeString, edge.toString());
    }
}
