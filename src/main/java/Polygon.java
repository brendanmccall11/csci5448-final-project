import java.util.ArrayList;
import java.util.List;

public class Polygon {

    private final List<Edge> edges;

    public Polygon() {
        edges = new ArrayList<>();
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
        List<Point> connectedPoints = Edge.getConnectedPoints(connectedEdges);


//        polygon.updatePointInEdges(connectedEdges);
//        polygon.connectEdges(connectedEdges);

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

}
