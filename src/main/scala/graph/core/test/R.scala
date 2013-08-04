package graph.core.test

import scalax.collection.mutable.Graph
import scalax.collection.GraphEdge.UnDiEdge
import scalax.collection.GraphPredef._

case class AClass(label: String)

object GraphTest extends App {
  val graph = Graph[AClass, UnDiEdge]()
  graph += AClass("A") ~ AClass("B")
  graph += AClass("C") ~ AClass("D")

  graph.nodes.foreach {
    case n => println(n.label)
  }
}
