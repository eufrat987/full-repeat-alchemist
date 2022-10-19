package graph

class Graph(var vertices: List[Vertex]) {

  def getNeighbours(index: Int): List[Int] = vertices(index).neigbours

  def addToNeighbours(x: Int, a: Int) = {
    vertices(x).neigbours = a :: vertices(x).neigbours
  }

  def revertAdd(x: Int) = {
    vertices(x).neigbours = vertices(x).neigbours.tail
  }
  
  def notNeighbours(x: Int) : Set[Int] = {
    vertices.map(_.index).toSet.diff((x :: vertices(x).neigbours).toSet)
  }

  def moveFirst(v: Int) = {
    val first = vertices.find(_.index == v)
    val rest = vertices.filter(_.index != v)
    vertices = first.get :: rest
  }
  
  override def toString: String = vertices.toString()
}
