package graph.core.test

class Test2 {
  import scalax.collection.Graph
  import scalax.collection.edge.Implicits._
  val g = Graph(("a" ~+#> "b")("c"))
  val e = g.edges.head
  println(e._1 + " points to " + e._2 + " with label " + e.label)
}
