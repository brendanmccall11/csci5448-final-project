package kotlinPolygonComponents

import kotlinDrawingComponents.kotlinDrawer
import java.util.List
import javax.swing.JFrame

class kotlinPolygon(points: MutableList<kotlinPoint?>, edges: MutableList<kotlinEdge?>) {
    val points: MutableList<kotlinPoint?> = ArrayList<kotlinPoint?>()
    val edges: MutableList<kotlinEdge?> = ArrayList<kotlinEdge?>()
    private var drawPolygon: kotlinDrawer? = null

    init {
        addPoints(points)
        addEdges(edges)
    }

    override fun toString(): String {
        val output = StringBuilder("Polygon:\n")
        for (edge in edges) {
            output.append(edge.toString()).append("\n")
        }
        return output.toString()
    }

    private fun addEdges(edges: MutableList<kotlinEdge?>) {
        this.edges.addAll(edges)
    }

    private fun addPoints(points: MutableList<kotlinPoint?>) {
        this.points.addAll(points)
    }

    fun removeKotlinPoint(deletedPoint: kotlinPoint?) {
        val connectedEdges = getConnectedEdges(deletedPoint)
        val tempEdge = kotlinEdge(null, null)
        val newEdge = tempEdge.flipKotlinEdge(connectedEdges)
        addNewEdge(newEdge)
        removePreviousEdges(connectedEdges)
    }

    private fun addNewEdge(newEdge: kotlinEdge?) {
        edges.add(newEdge!!)
    }

    private fun removePreviousEdges(connectedEdges: MutableList<kotlinEdge>) {
        edges.remove(connectedEdges.first())
        edges.remove(connectedEdges.last())
    }

    fun removeKotlinEdge(edge: kotlinEdge?) {
        this.edges.remove(edge)
        val connectedEdges = getConnectedEdges(edge)
        val adjacentEdge: kotlinEdge = connectedEdges.first()

        val startingPoint = edge?.startingPoint  // Changed from getStartingPoint()
        val endingPoint = edge?.endingPoint     // Changed from getEndingPoint()

        if (startingPoint == adjacentEdge.startingPoint) {
            adjacentEdge.startingPoint = endingPoint  // Changed from setStartingPoint()
            this.points.remove(startingPoint)
        } else if (startingPoint == adjacentEdge.endingPoint) {
            adjacentEdge.endingPoint = endingPoint  // Changed from setEndingPoint()
            this.points.remove(startingPoint)
        } else if (endingPoint == adjacentEdge.startingPoint) {
            adjacentEdge.startingPoint = startingPoint  // Changed from setStartingPoint()
            this.points.remove(endingPoint)
        } else if (endingPoint == adjacentEdge.endingPoint) {
            adjacentEdge.endingPoint = startingPoint  // Changed from setEndingPoint()
            this.points.remove(endingPoint)
        }
    }

    fun getConnectedEdges(givenPoint: kotlinPoint?): MutableList<kotlinEdge> {
        val connectedEdges: MutableList<kotlinEdge> = ArrayList<kotlinEdge>()
        for (edge in edges) {
            edge?.let {
                if (it.isConnectedEdge(givenPoint)) {
                    connectedEdges.add(edge)
                }
            }
        }
        return connectedEdges
    }

    fun getConnectedEdges(givenEdge: kotlinEdge?): MutableList<kotlinEdge> {
        val startingPoint = givenEdge?.startingPoint  // Changed from getStartingPoint()
        val endingPoint = givenEdge?.endingPoint     // Changed from getEndingPoint()

        val connectedStartingPointEdges = getConnectedEdges(startingPoint)
        val connectedEndingPointEdges = getConnectedEdges(endingPoint)

        connectedStartingPointEdges.remove(givenEdge)
        connectedEndingPointEdges.remove(givenEdge)

        return List.of<kotlinEdge?>(connectedStartingPointEdges.first(), connectedEndingPointEdges.first())
    }

    fun draw() {
        drawPolygon = kotlinDrawer(this)
        val frame = JFrame()

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
        frame.setSize(500, 500)
        frame.setVisible(true)

        frame.add(drawPolygon)
    }

    fun updateDrawing() {
        drawPolygon!!.repaint()
    }
}