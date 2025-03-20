import java.util.ArrayList;
import java.util.List;

public class Edge {

    private Point startingPoint;
    private Point endingPoint;

    public Edge(Point startingPoint, Point endingPoint) {
        this.startingPoint = startingPoint;
        this.endingPoint = endingPoint;
    }

    @Override
    public String toString() {
        return "Edge: " + startingPoint + ", " + endingPoint;
    }

    public Point getStartingPoint() {
        return startingPoint;
    }

    public Point getEndingPoint() {
        return endingPoint;
    }

    public Boolean isConnectedEdge(Point point){
        return point == startingPoint || point == endingPoint;
    }

    public void replacePoint(Point deletedPoint, Point newPoint){
        if(deletedPoint == startingPoint){
            this.startingPoint = newPoint;
        }
        if(deletedPoint == endingPoint){
            this.endingPoint = newPoint;
        }
    }

    public static List<Point> getConnectedPoints(List<Edge> connectedEdges){
        List<Point> connectedPoints = new ArrayList<>();
        Edge edgeA = connectedEdges.getFirst();
        Edge edgeB = connectedEdges.getLast();

        if(edgeA.startingPoint == edgeB.startingPoint){
            connectedPoints.add(edgeA.endingPoint);
            connectedPoints.add(edgeB.endingPoint);
        } else if(edgeA.endingPoint == edgeB.endingPoint){
            connectedPoints.add(edgeA.startingPoint);
            connectedPoints.add(edgeB.startingPoint);
        } else if(edgeA.startingPoint == edgeB.endingPoint){
            connectedPoints.add(edgeA.endingPoint);
            connectedPoints.add(edgeB.startingPoint);
        } else if(edgeA.endingPoint == edgeB.startingPoint){
            connectedPoints.add(edgeA.startingPoint);
            connectedPoints.add(edgeB.endingPoint);
        }
        return connectedPoints;
    }

}
