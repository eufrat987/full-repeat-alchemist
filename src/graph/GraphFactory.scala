package graph

object GraphFactory {

  def verticesNum(lines: List[String]): Int = {
    val howManyVertices = lines.filter(_ startsWith "p")
    val verticesNum = howManyVertices.head.split(" ")(2)

    verticesNum.toInt
  }

  def create(lines: List[String]): Graph = {
    val num = verticesNum(lines)

    val vertices: List[Vertex] = (0 to num)
      .map(Vertex(_, List()))
      .toList

    lines.foreach(x => {
      if x startsWith ("e") then
        val Array(_, v, vv) = x split (" ")
        val index = v.toInt
        val neigh = vv.toInt
        vertices(index).neigbours = neigh :: vertices(index).neigbours
        vertices(neigh).neigbours = index :: vertices(neigh).neigbours
    })
    Graph(vertices)
  }
}
