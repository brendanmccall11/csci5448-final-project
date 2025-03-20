public class Edge {

    private final Point startingPoint;
    private final Point endingPoint;

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

}
