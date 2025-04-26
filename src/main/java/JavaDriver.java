import PolygonComponents.Edge;
import PolygonComponents.Point;
import PolygonComponents.Polygon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaDriver {

    public static void main(String[] args) throws InterruptedException {
        List<Long> executionTimes = new ArrayList<>();
        int numRuns = 30;

        for (int i = 0; i < numRuns; i++) {
            long startTime = System.currentTimeMillis();

            Polygon polygon = createPolygon20Vertices();
            polygon.draw();

            double pointsPreserved = 0.8;
            deleteEdges(polygon, pointsPreserved);

            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;
            executionTimes.add(executionTime);

            System.out.println("Run " + (i+1) + ": " + executionTime + " ms");
        }

        double averageTime = executionTimes.stream()
                .mapToLong(Long::longValue)
                .average()
                .orElse(0.0);

        System.out.printf("\nAverage execution time over %d runs: %.2f ms\n",
                numRuns, averageTime);
    }

    public static Polygon createPolygon6Vertices() {
        Point pointA = new Point(50, 100);
        Point pointB = new Point(100, 150);
        Point pointC = new Point(150, 100);
        Point pointD = new Point(200, 150);
        Point pointE = new Point(250, 100);
        Point pointF = new Point(200, 50);

        Edge edgeAB = new Edge(pointA, pointB);
        Edge edgeBC = new Edge(pointB, pointC);
        Edge edgeCD = new Edge(pointC, pointD);
        Edge edgeDE = new Edge(pointD, pointE);
        Edge edgeEF = new Edge(pointE, pointF);
        Edge edgeFA = new Edge(pointF, pointA);

        List<Point> points = List.of(pointA, pointB, pointC, pointD, pointE, pointF);
        List<Edge> edges = Arrays.asList(edgeAB, edgeBC, edgeCD, edgeDE, edgeEF, edgeFA);
        return new Polygon(points, edges);
    }

    public static Polygon createPolygon20Vertices() {
        Point pointA = new Point(250, 150);
        Point pointB = new Point(285, 160);
        Point pointC = new Point(310, 185);
        Point pointD = new Point(320, 215);
        Point pointE = new Point(315, 250);
        Point pointF = new Point(300, 280);
        Point pointG = new Point(275, 295);
        Point pointH = new Point(245, 300);
        Point pointI = new Point(215, 290);
        Point pointJ = new Point(190, 270);
        Point pointK = new Point(175, 245);
        Point pointL = new Point(165, 215);
        Point pointM = new Point(170, 185);
        Point pointN = new Point(185, 160);
        Point pointO = new Point(215, 145);
        Point pointP = new Point(230, 125);
        Point pointQ = new Point(260, 120);
        Point pointR = new Point(280, 130);
        Point pointS = new Point(295, 145);
        Point pointT = new Point(270, 140);

        Edge edgeAB = new Edge(pointA, pointB);
        Edge edgeBC = new Edge(pointB, pointC);
        Edge edgeCD = new Edge(pointC, pointD);
        Edge edgeDE = new Edge(pointD, pointE);
        Edge edgeEF = new Edge(pointE, pointF);
        Edge edgeFG = new Edge(pointF, pointG);
        Edge edgeGH = new Edge(pointG, pointH);
        Edge edgeHI = new Edge(pointH, pointI);
        Edge edgeIJ = new Edge(pointI, pointJ);
        Edge edgeJK = new Edge(pointJ, pointK);
        Edge edgeKL = new Edge(pointK, pointL);
        Edge edgeLM = new Edge(pointL, pointM);
        Edge edgeMN = new Edge(pointM, pointN);
        Edge edgeNO = new Edge(pointN, pointO);
        Edge edgeOP = new Edge(pointO, pointP);
        Edge edgePQ = new Edge(pointP, pointQ);
        Edge edgeQR = new Edge(pointQ, pointR);
        Edge edgeRS = new Edge(pointR, pointS);
        Edge edgeST = new Edge(pointS, pointT);
        Edge edgeTA = new Edge(pointT, pointA);

        List<Point> points = List.of(
                pointA, pointB, pointC, pointD, pointE,
                pointF, pointG, pointH, pointI, pointJ,
                pointK, pointL, pointM, pointN, pointO,
                pointP, pointQ, pointR, pointS, pointT
        );

        List<Edge> edges = Arrays.asList(
                edgeAB, edgeBC, edgeCD, edgeDE, edgeEF,
                edgeFG, edgeGH, edgeHI, edgeIJ, edgeJK,
                edgeKL, edgeLM, edgeMN, edgeNO, edgeOP,
                edgePQ, edgeQR, edgeRS, edgeST, edgeTA
        );
        return new Polygon(points, edges);
    }

    private static int calculateNumPointsToDelete(Polygon polygon, double decimalOfPointsPreserved){
        double pointsLost = 1 - decimalOfPointsPreserved;
        int numPoints = polygon.getPoints().size();
        double numPointsToDelete = numPoints*pointsLost;
        return (int) Math.round(numPointsToDelete);
    }

    private static int calculateDeletedPointsSpacing(Polygon polygon, int numPointsDeleted) {
        int numPoints = polygon.getPoints().size();
        int numRemainingPoints = numPoints - numPointsDeleted;

        double numPointsToSkip = (double) numRemainingPoints / numPointsDeleted;
        return (int) Math.floor(numPointsToSkip);
    }

    private static void removeEdge(Polygon polygon, int i) throws InterruptedException {
        int millisecondsPaused = 1000;
        Thread.sleep(millisecondsPaused);
        polygon.removeEdge(polygon.getEdges().get(i));
        polygon.updateDrawing();
    }

    private static void deleteEdges(Polygon polygon, double pointsPreserved) throws InterruptedException {
        int numPointsDeleted = calculateNumPointsToDelete(polygon, pointsPreserved);
        int numPointsToSkip = calculateDeletedPointsSpacing(polygon, numPointsDeleted);

        int numEdgesDeletedSoFar = 0;
        int currentEdge= 0;
        int numEdgesSkipped = 0;
        while(numEdgesDeletedSoFar != numPointsDeleted) {

            if(numEdgesSkipped == numPointsToSkip) {
                removeEdge(polygon, currentEdge);
                numEdgesDeletedSoFar++;
                numEdgesSkipped = 0;
            }else{
                numEdgesSkipped++;
                currentEdge++;
            }
        }
    }
}
