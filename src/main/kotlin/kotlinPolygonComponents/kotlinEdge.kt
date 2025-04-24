package kotlinPolygonComponents

class kotlinEdge(var startingPoint: kotlinPoint?, var endingPoint: kotlinPoint?) {

    override fun toString(): String = "Edge: $startingPoint, $endingPoint"

    fun isConnectedEdge(point: kotlinPoint?): Boolean {
        return point === startingPoint || point === endingPoint
    }

    fun getConnectedPoints(connectedEdges: MutableList<kotlinEdge>): MutableList<kotlinPoint?> {
        val connectedPoints = mutableListOf<kotlinPoint?>()
        val (edgeA, edgeB) = connectedEdges.first() to connectedEdges.last()

        when {
            edgeA.startingPoint === edgeB.startingPoint -> {
                connectedPoints.add(edgeA.endingPoint)
                connectedPoints.add(edgeB.endingPoint)
            }
            edgeA.endingPoint === edgeB.endingPoint -> {
                connectedPoints.add(edgeA.startingPoint)
                connectedPoints.add(edgeB.startingPoint)
            }
            edgeA.startingPoint === edgeB.endingPoint -> {
                connectedPoints.add(edgeA.endingPoint)
                connectedPoints.add(edgeB.startingPoint)
            }
            edgeA.endingPoint === edgeB.startingPoint -> {
                connectedPoints.add(edgeA.startingPoint)
                connectedPoints.add(edgeB.endingPoint)
            }
        }
        return connectedPoints
    }

    fun flipKotlinEdge(connectedEdges: MutableList<kotlinEdge>): kotlinEdge {
        val connectedPoints = getConnectedPoints(connectedEdges)
        return kotlinEdge(connectedPoints.first(), connectedPoints.last())
    }
}