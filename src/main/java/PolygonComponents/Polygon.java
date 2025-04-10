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

    private void addPoints(List<Point> points){
        this.points.addAll(points);
    }

    private void addEdges(List<Edge> edges){
        this.edges.addAll(edges);
    }

//    public void removeEdge(Edge e) {
//        edges.remove(e);
//    }

    public List<Point> getPoints() {
        return points;
    }

    public List<Edge> getEdges(){
        return edges;
    }

    public String toString() {
        StringBuilder output = new StringBuilder("PolygonComponents.Polygon:\n");
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

    public void draw(){
        Drawer drawPolygon = new Drawer(this);
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(drawPolygon);

        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    public void removeEdge(Edge edge){
        this.edges.remove(edge);

        List<Edge> connectedEdges = getConnectedEdges(edge);
        Edge firstAdjacentEdge = connectedEdges.getFirst();
        Edge secondAdjacentEdge = connectedEdges.getLast();


        Point startingPoint = edge.getStartingPoint();
        Point endingPoint = edge.getEndingPoint();

//        if(startingPoint.equals(secondAdjacentEdge.getStartingPoint())){
//            secondAdjacentEdge.setStartingPoint(endingPoint);
//        } else if (startingPoint.equals(secondAdjacentEdge.getEndingPoint())){
//            secondAdjacentEdge.setEndingPoint(endingPoint);
//        } else if (endingPoint.equals(secondAdjacentEdge.getStartingPoint())){
//            secondAdjacentEdge.setStartingPoint(startingPoint);
//        } else if (endingPoint.equals(secondAdjacentEdge.getEndingPoint())){
//            secondAdjacentEdge.setEndingPoint(startingPoint);
//        }


    }

    public List<Edge> getConnectedEdges(Edge givenEdge){
        Point startingPoint = givenEdge.getStartingPoint();
        Point endingPoint = givenEdge.getEndingPoint();

        List<Edge> connectedStartingPointEdges = getConnectedEdges(startingPoint);
        List<Edge> connectedEndingPointEdges = getConnectedEdges(endingPoint);

        connectedStartingPointEdges.remove(givenEdge);
        connectedEndingPointEdges.remove(givenEdge);

        List<Edge> connectedEdges = List.of(connectedStartingPointEdges.getFirst(), connectedEndingPointEdges.getFirst());
        return connectedEdges;
    }

}
