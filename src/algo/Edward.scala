package algo

import graph.Graph

class Edward(graph : Graph) extends Algo {
  val numOfVertices: Int = graph.vertices.length - 1

  def solve() : Int = {
    var g = Greed(graph)
    var mc = g.solve()
    println(mc)
    (1 to numOfVertices).foreach(x => {
      print(x + " ")
      val toAdd = graph.notNeighbours(x)
      toAdd.foreach(a => {
        graph.addToNeighbours(x, a)
        g = Greed(graph)
        val nmc = g.solve()
        if (nmc <= mc) {
          mc = nmc
          println(mc)
        } else {
          graph.revertAdd(x)
        }
      })
    })
    mc
  }
}
