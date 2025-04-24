package kotlinPolygonComponents

class kotlinPoint {

    var xValue = 0
    var yValue = 0

    fun kotlinPoint(xValue: Int, yValue: Int) {
        this.xValue = xValue
        this.yValue = yValue
    }

    override fun toString(): String {
        return "($xValue, $yValue)"
    }

    fun getXValue(): Int {
        return xValue
    }

    fun getYValue(): Int {
        return yValue
    }
}