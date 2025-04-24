import kotlinPolygonComponents.kotlinEdge
import kotlinPolygonComponents.kotlinPoint
import kotlinPolygonComponents.kotlinPolygon
import java.util.*
import java.util.List

class KotlinDriver {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            KotlinDriver().run {
                val kotlinPolygon = createPolygon20Vertices()
                kotlinPolygon.draw()

                val millisecondsPaused = 2000
                Thread.sleep(millisecondsPaused.toLong())

                kotlinPolygon.removeKotlinEdge(kotlinPolygon.edges.elementAt(2))
                kotlinPolygon.updateDrawing()
            }
        }
    }

    fun createPolygon6Vertices(): kotlinPolygon {
        val pointA = kotlinPoint(50, 100)
        val pointB = kotlinPoint(100, 150)
        val pointC = kotlinPoint(150, 100)
        val pointD = kotlinPoint(200, 150)
        val pointE = kotlinPoint(250, 100)
        val pointF = kotlinPoint(200, 50)

        val edgeAB = kotlinEdge(pointA, pointB)
        val edgeBC = kotlinEdge(pointB, pointC)
        val edgeCD = kotlinEdge(pointC, pointD)
        val edgeDE = kotlinEdge(pointD, pointE)
        val edgeEF = kotlinEdge(pointE, pointF)
        val edgeFA = kotlinEdge(pointF, pointA)

        val points = List.of<kotlinPoint?>(pointA, pointB, pointC, pointD, pointE, pointF)
        val edges = Arrays.asList<kotlinEdge?>(edgeAB, edgeBC, edgeCD, edgeDE, edgeEF, edgeFA)
        return kotlinPolygon(points, edges)
    }

    fun createPolygon20Vertices(): kotlinPolygon {
        val pointA = kotlinPoint(250, 150)
        val pointB = kotlinPoint(285, 160)
        val pointC = kotlinPoint(310, 185)
        val pointD = kotlinPoint(320, 215)
        val pointE = kotlinPoint(315, 250)
        val pointF = kotlinPoint(300, 280)
        val pointG = kotlinPoint(275, 295)
        val pointH = kotlinPoint(245, 300)
        val pointI = kotlinPoint(215, 290)
        val pointJ = kotlinPoint(190, 270)
        val pointK = kotlinPoint(175, 245)
        val pointL = kotlinPoint(165, 215)
        val pointM = kotlinPoint(170, 185)
        val pointN = kotlinPoint(185, 160)
        val pointO = kotlinPoint(215, 145)
        val pointP = kotlinPoint(230, 125)
        val pointQ = kotlinPoint(260, 120)
        val pointR = kotlinPoint(280, 130)
        val pointS = kotlinPoint(295, 145)
        val pointT = kotlinPoint(270, 140)

        val edgeAB = kotlinEdge(pointA, pointB)
        val edgeBC = kotlinEdge(pointB, pointC)
        val edgeCD = kotlinEdge(pointC, pointD)
        val edgeDE = kotlinEdge(pointD, pointE)
        val edgeEF = kotlinEdge(pointE, pointF)
        val edgeFG = kotlinEdge(pointF, pointG)
        val edgeGH = kotlinEdge(pointG, pointH)
        val edgeHI = kotlinEdge(pointH, pointI)
        val edgeIJ = kotlinEdge(pointI, pointJ)
        val edgeJK = kotlinEdge(pointJ, pointK)
        val edgeKL = kotlinEdge(pointK, pointL)
        val edgeLM = kotlinEdge(pointL, pointM)
        val edgeMN = kotlinEdge(pointM, pointN)
        val edgeNO = kotlinEdge(pointN, pointO)
        val edgeOP = kotlinEdge(pointO, pointP)
        val edgePQ = kotlinEdge(pointP, pointQ)
        val edgeQR = kotlinEdge(pointQ, pointR)
        val edgeRS = kotlinEdge(pointR, pointS)
        val edgeST = kotlinEdge(pointS, pointT)
        val edgeTA = kotlinEdge(pointT, pointA)

        val points = listOf<kotlinPoint?>(
            pointA, pointB, pointC, pointD, pointE,
            pointF, pointG, pointH, pointI, pointJ,
            pointK, pointL, pointM, pointN, pointO,
            pointP, pointQ, pointR, pointS, pointT
        )

        val edges = listOf<kotlinEdge?>(
            edgeAB, edgeBC, edgeCD, edgeDE, edgeEF,
            edgeFG, edgeGH, edgeHI, edgeIJ, edgeJK,
            edgeKL, edgeLM, edgeMN, edgeNO, edgeOP,
            edgePQ, edgeQR, edgeRS, edgeST, edgeTA
        )
        return kotlinPolygon(points as MutableList<kotlinPoint?>, edges as MutableList<kotlinEdge?>)
    }
}