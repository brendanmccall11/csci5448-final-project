package kotlinDrawingComponents

import kotlinPolygonComponents.kotlinPoint
import kotlinPolygonComponents.kotlinPolygon
import java.awt.Color
import java.awt.Graphics
import javax.swing.JPanel

class kotlinDrawer(private val polygon: kotlinPolygon) : JPanel() {
    public override fun paintComponent(graphics: Graphics) {
        super.paintComponent(graphics)
        val points = changePointsToArray(polygon)

        drawPoints(graphics, points)
        graphics.drawPolygon(kotlinPolygonWrapper().wrap((points)))
    }

    private fun changePointsToArray(polygon: kotlinPolygon): Array<kotlinPoint> {
        val points: Array<kotlinPoint> = arrayOfNulls<kotlinPoint>(polygon.points.size) as Array<kotlinPoint>
        for (i in polygon.points.indices) {
            polygon.points[i]?.let { points[i] = it }
        }
        return points
    }

    private fun drawPoints(graphics: Graphics, points: Array<kotlinPoint>) {
        graphics.color = Color.BLUE
        for (point in points) {
            drawPoint(graphics, point)
        }
    }

    private fun drawPoint(graphics: Graphics, point: kotlinPoint) {
        val xCoordinate = point.getXValue()
        val yCoordinate = point.getYValue()
        val RADIUS_OF_POINT = 7
        val DIAMETER = 2 * RADIUS_OF_POINT
        graphics.fillOval(xCoordinate - RADIUS_OF_POINT, yCoordinate - RADIUS_OF_POINT, DIAMETER, DIAMETER)
    }
}
