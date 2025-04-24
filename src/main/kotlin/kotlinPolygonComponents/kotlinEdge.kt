package kotlinPolygonComponents

class kotlinEdge(var startingPoint: kotlinPoint?, var endingPoint: kotlinPoint?) {

    override fun toString(): String {
        return "Edge: $startingPoint, $endingPoint"
    }

    fun getStartingPoint(): kotlinPoint? {
        return startingPoint
    }

    fun getEndingPoint(): kotlinPoint? {
        return endingPoint
    }

    fun setStartingPoint(startingPoint: kotlinPoint?) {
        this.startingPoint = startingPoint
    }

    fun setEndingPoint(endingPoint: kotlinPoint?) {
        this.endingPoint = endingPoint
    }

    fun isConnectedEdge(point: kotlinPoint?): Boolean {
        return point === startingPoint || point === endingPoint
    }

    fun getConnectedPoints(connectedEdges: MutableList<kotlinEdge>): MutableList<kotlinPoint?> {
        val connectedPoints: MutableList<kotlinPoint?> = ArrayList<kotlinPoint?>()
        val edgeA: kotlinEdge = connectedEdges.first()
        val edgeB: kotlinEdge = connectedEdges.last()

        if (edgeA.startingPoint === edgeB.startingPoint) {
            connectedPoints.add(edgeA.endingPoint)
            connectedPoints.add(edgeB.endingPoint)
        } else if (edgeA.endingPoint === edgeB.endingPoint) {
            connectedPoints.add(edgeA.startingPoint)
            connectedPoints.add(edgeB.startingPoint)
        } else if (edgeA.startingPoint === edgeB.endingPoint) {
            connectedPoints.add(edgeA.endingPoint)
            connectedPoints.add(edgeB.startingPoint)
        } else if (edgeA.endingPoint === edgeB.startingPoint) {
            connectedPoints.add(edgeA.startingPoint)
            connectedPoints.add(edgeB.endingPoint)
        }
        return connectedPoints
    }

    fun flipKotlinEdge(connectedEdges: MutableList<kotlinEdge>): kotlinEdge {
        val connectedPoints = getConnectedPoints(connectedEdges)
        return kotlinEdge(connectedPoints.first(), connectedPoints.last())
    }
}