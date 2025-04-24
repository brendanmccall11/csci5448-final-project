package kotlinDrawingComponents

import kotlinPolygonComponents.kotlinPoint
import java.awt.Polygon

class kotlinPolygonWrapper {

    fun wrap(points: Array<kotlinPoint>): Polygon {
        val numberOfPoints = points.size
        val xCoordinates = IntArray(numberOfPoints)
        val yCoordinates = IntArray(numberOfPoints)

        for (i in 0..< numberOfPoints) {
            xCoordinates[i] = points[i]!!.xValue
            yCoordinates[i] = points[i]!!.yValue
        }
        return Polygon(xCoordinates, yCoordinates, numberOfPoints)
    }
}