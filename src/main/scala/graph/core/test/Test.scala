package graph.core.test

import scalax.collection.edge.LkDiEdge

class Test {
  import scalax.collection.Graph
  import scalax.collection.edge.Implicits._

  val g: Graph[String, LkDiEdge] = Graph.apply("a".~+#>("b")("c"))
}
