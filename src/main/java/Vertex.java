public class Vertex {

    private int xValue;
    private int yValue;

    public Vertex(int xValue, int yValue) {
        this.xValue = xValue;
        this.yValue = yValue;
    }

    @Override
    public String toString() {
        return "(" + xValue + ", " + yValue + ")";
    }

}
