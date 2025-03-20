public class Point {

    private final int xValue;
    private final int yValue;

    public Point(int xValue, int yValue) {
        this.xValue = xValue;
        this.yValue = yValue;
    }

    @Override
    public String toString() {
        return "(" + xValue + ", " + yValue + ")";
    }

}
