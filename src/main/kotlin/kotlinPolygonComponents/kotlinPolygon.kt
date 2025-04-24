package kotlinPolygonComponents

import kotlinDrawingComponents.kotlinDrawer
import java.util.List
import javax.swing.JFrame

class kotlinPolygon(points: Collection<kotlinPoint?>, edges: Collection<kotlinEdge>) {
    val points: MutableList<kotlinPoint?> = ArrayList<kotlinPoint?>()
    private val edges: MutableList<kotlinEdge> = ArrayList<kotlinEdge>()
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

    fun getEdges(): Collection<kotlinEdge> {
        return edges
    }

    fun getPoints(): Collection<kotlinPoint?> {
        return points
    }

    private fun addEdges(edges: Collection<kotlinEdge>) {
        this.edges.addAll(edges)
    }

    private fun addPoints(points: Collection<kotlinPoint?>) {
        this.points.addAll(points)
    }

    fun removeKotlinPoint(deletedPoint: kotlinPoint?) {
        val connectedEdges = getConnectedEdges(deletedPoint)
        val tempEdge = kotlinEdge()
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

    fun removeKotlinEdge(edge: kotlinEdge) {
        this.edges.remove(edge)
        val connectedEdges = getConnectedEdges(edge)
        val adjacentEdge: kotlinEdge = connectedEdges.first()

        val startingPoint = edge.getStartingPoint()
        val endingPoint = edge.getEndingPoint()

        if (startingPoint == adjacentEdge.getStartingPoint()) {
            adjacentEdge.setStartingPoint(endingPoint)
            this.points.remove(startingPoint)
        } else if (startingPoint == adjacentEdge.getEndingPoint()) {
            adjacentEdge.setEndingPoint(endingPoint)
            this.points.remove(startingPoint)
        } else if (endingPoint == adjacentEdge.getStartingPoint()) {
            adjacentEdge.setStartingPoint(startingPoint)
            this.points.remove(endingPoint)
        } else if (endingPoint == adjacentEdge.getEndingPoint()) {
            adjacentEdge.setEndingPoint(startingPoint)
            this.points.remove(endingPoint)
        }
    }

    fun getConnectedEdges(givenPoint: kotlinPoint?): MutableList<kotlinEdge> {
        val connectedEdges: MutableList<kotlinEdge> = ArrayList<kotlinEdge>()
        for (edge in edges) {
            if (edge.isConnectedEdge(givenPoint)) {
                connectedEdges.add(edge)
            }
        }
        return connectedEdges
    }

    fun getConnectedEdges(givenEdge: kotlinEdge): MutableList<kotlinEdge> {
        val startingPoint = givenEdge.getStartingPoint()
        val endingPoint = givenEdge.getEndingPoint()

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