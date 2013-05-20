package graph.core.test

object Test3 {
  import scalax.collection.GraphEdge.DiEdge
  import scalax.collection.GraphPredef._
  import scalax.collection.GraphTraversal.VisitorReturn
  import scalax.collection.{GraphTraversal, Graph}
  val g = Graph[String, DiEdge]("1" ~> "2", "2" ~> "3", "3" ~> "4")
  g.get("1").traverseNodes(GraphTraversal.Successors) {
    node: g.NodeT => {
      val s: String = node
      println(s.toInt)
      VisitorReturn.Continue
    }
  }
}


