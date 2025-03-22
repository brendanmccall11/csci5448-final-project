import java.util.ArrayList;
import java.util.List;

public class Polygon {

    private final List<Edge> edges = new ArrayList<>();
    //private final List<Point> points;

    public Polygon(List<Edge> edges) {
        addEdges(edges);
    }

    public Polygon() {
    }

    private void addEdges(List<Edge> edges){
        this.edges.addAll(edges);
    }

    public void addEdge(Edge e) {
        edges.add(e);
    }

    public void removeEdge(Edge e) {
        edges.remove(e);
    }

    public List<Edge> getEdges(){
        return edges;
    }

    public String toString() {
        StringBuilder output = new StringBuilder("Polygon:\n");
        for (Edge edge : edges) {
            output.append(edge.toString()).append("\n");
        }
        return output.toString();
    }

    public void removePoint(Point deletedPoint){
        List<Edge> connectedEdges = getConnectedEdges(deletedPoint);
        Edge newEdge = Edge.flipEdge(connectedEdges);
        addNewEdge(newEdge);
        removePreviousEdges(connectedEdges);
    }

    public List<Edge> getConnectedEdges(Point givenPoint) {
        List<Edge> connectedEdges = new ArrayList<>();
        for(Edge edge : edges){
            if(edge.isConnectedEdge(givenPoint)){
                connectedEdges.add(edge);
            }
        }
        return connectedEdges;
    }

    private void addNewEdge(Edge newEdge) {
        edges.add(newEdge);
    }

    private void removePreviousEdges(List<Edge> connectedEdges) {
        edges.remove(connectedEdges.getFirst());
        edges.remove(connectedEdges.getLast());
    }

}
