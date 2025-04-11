package PolygonComponents;

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

    public void setStartingPoint(Point startingPoint) {
        this.startingPoint = startingPoint;
    }

    public void setEndingPoint(Point endingPoint) {
        this.endingPoint = endingPoint;
    }

    public Boolean isConnectedEdge(Point point){
        return point == startingPoint || point == endingPoint;
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

    public static Edge flipEdge(List<Edge> connectedEdges){
        List<Point> connectedPoints = Edge.getConnectedPoints(connectedEdges);
        return new Edge(connectedPoints.getFirst(), connectedPoints.getLast());
    }

}
