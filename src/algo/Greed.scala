package algo

import graph.Graph

class Greed(graph: Graph) extends Algo {
  var colors: Array[Int] = graph.vertices.map(x => 1).toArray
  val numOfVertices = graph.vertices.length - 1

  def conflict(index: Int): Boolean = {
    graph
      .getNeighbours(index)
      .exists(colors(index) == colors(_))
  }

  def colorV(index: Int) = {
    while (conflict(index)) {
      colors(index) += 1
    }
  }

  def solve(): Int = {
    (1 to numOfVertices).foreach(x => {
      colorV(x)
    })

    colors.max
  }
}
