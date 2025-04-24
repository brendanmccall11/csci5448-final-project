package kotlinPolygonComponents

class kotlinPoint(var xValue: Int, var yValue: Int) {

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