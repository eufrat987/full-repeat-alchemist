import algo.Greed
import algo.Edward
import file.FileReader
import graph.GraphFactory

@main def main(): Unit = {
  val lines = FileReader("aaa").content.get
  val graph = GraphFactory.create(lines)

  val a = Edward(graph)
  println(a.solve())
}
