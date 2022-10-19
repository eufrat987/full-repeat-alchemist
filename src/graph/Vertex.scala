package graph

class Vertex(var index : Int,
             var neigbours : List[Int]) {

  override def toString: String = index + " " + neigbours.toString() + '\n'
}
