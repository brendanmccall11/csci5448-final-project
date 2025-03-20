public class Edge {

    private final Vertex vertexA;
    private final Vertex vertexB;

    public Edge(Vertex startingVertex, Vertex endingVertex) {
        this.vertexA = startingVertex;
        this.vertexB = endingVertex;
    }

    @Override
    public String toString() {
        return "Edge: " + vertexA + ", " + vertexB;
    }
}
