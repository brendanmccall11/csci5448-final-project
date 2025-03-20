public class Point {

    private final double xValue;
    private final double yValue;

    public Point(double xValue, double yValue) {
        this.xValue = xValue;
        this.yValue = yValue;
    }

    @Override
    public String toString() {
        return "(" + xValue + ", " + yValue + ")";
    }

}
