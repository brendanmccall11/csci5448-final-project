package PolygonComponents;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import DrawingComponents.Drawer;

public class Polygon extends java.awt.Polygon {

    private final List<Point> points = new ArrayList<>();
    private final List<Edge> edges = new ArrayList<>();

    public Polygon( List<Point> points, List<Edge> edges) {
        addPoints(points);
        addEdges(edges);
    }

    public String toString() {
        StringBuilder output = new StringBuilder("Polygon:\n");
        for (Edge edge : edges) {
            output.append(edge.toString()).append("\n");
        }
        return output.toString();
    }

    public List<Edge> getEdges(){
        return edges;
    }

    public List<Point> getPoints() {
        return points;
    }

    private void addEdges(List<Edge> edges){
        this.edges.addAll(edges);
    }

    private void addPoints(List<Point> points){
        this.points.addAll(points);
    }

    public void removePoint(Point deletedPoint){
        List<Edge> connectedEdges = getConnectedEdges(deletedPoint);
        Edge newEdge = Edge.flipEdge(connectedEdges);
        addNewEdge(newEdge);
        removePreviousEdges(connectedEdges);
    }

    private void addNewEdge(Edge newEdge) {
        edges.add(newEdge);
    }

    private void removePreviousEdges(List<Edge> connectedEdges) {
        edges.remove(connectedEdges.getFirst());
        edges.remove(connectedEdges.getLast());
    }

    public void removeEdge(Edge edge){
        this.edges.remove(edge);
        List<Edge> connectedEdges = getConnectedEdges(edge);
        Edge adjacentEdge = connectedEdges.getFirst();

        Point startingPoint = edge.getStartingPoint();
        Point endingPoint = edge.getEndingPoint();

        if(startingPoint.equals(adjacentEdge.getStartingPoint())){
            adjacentEdge.setStartingPoint(endingPoint);
        } else if (startingPoint.equals(adjacentEdge.getEndingPoint())){
            adjacentEdge.setEndingPoint(endingPoint);
        } else if (endingPoint.equals(adjacentEdge.getStartingPoint())){
            adjacentEdge.setStartingPoint(startingPoint);
        } else if (endingPoint.equals(adjacentEdge.getEndingPoint())){
            adjacentEdge.setEndingPoint(startingPoint);
        }
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

    public List<Edge> getConnectedEdges(Edge givenEdge){
        Point startingPoint = givenEdge.getStartingPoint();
        Point endingPoint = givenEdge.getEndingPoint();

        List<Edge> connectedStartingPointEdges = getConnectedEdges(startingPoint);
        List<Edge> connectedEndingPointEdges = getConnectedEdges(endingPoint);

        connectedStartingPointEdges.remove(givenEdge);
        connectedEndingPointEdges.remove(givenEdge);

        return List.of(connectedStartingPointEdges.getFirst(), connectedEndingPointEdges.getFirst());
    }

    public void draw(){
        Drawer drawPolygon = new Drawer(this);
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(drawPolygon);

        frame.setSize(500, 500);
        frame.setVisible(true);
    }

}
