package graph.core.test

import scala.Predef._
import scalax.collection.mutable.{Graph => MGraph}
import scalax.collection.GraphEdge._
import scalax.collection.edge._

import scalax.collection.mutable._
import scalax.collection.edge.LBase._
import scalax.collection.edge.Implicits._


case class Person(name:String)
case class Relationship(kind:String)

object Son extends Relationship("son")

object ConsoleGraphTester extends App
{

  case class Person(name:String)
  case class Relationship(kind:String)

  def generate():Graph[Person,LDiEdge] = {
    val g: Graph[Person,LDiEdge] = Graph.empty[Person,LDiEdge]
    val p = Person("root")

    val friend = "friend"
    val enemy = "enemy"
    val neutral = "neutral"
    val en = Relationship(enemy)
    val fr = Relationship(friend)
    val neu = Relationship(neutral)

    for(i<-1 until 10)
    {
      val fr1 = Person(friend+"_1_#"+i)
      val en1 = Person(enemy+"_1_#"+i)
      val neu1 = Person(neutral+"_1_#"+i)
      g.add((p~+>fr1)(fr))
      g.add((p~+>neu1)(neu))
      g.add((p~+>en1)(en))

      for(j<-1 until 10)
      {
        val fr2 = Person(friend+"_2_#"+i*10+j)
        val en2 = Person(enemy+"_2_#"+i*10+j)
        val neu2 = Person(neutral+"_2_#"+i*10+j)
        val v: LDiEdge[Person] with EdgeCopy[LDiEdge] {type L1 = Relationship} = (fr1~+>fr2)(fr)
        g.add((fr1~+>fr2)(fr))
        g.add((neu1~+>neu2)(neu))
        g.add((en1~+>en2)(en))

      }
    }
    return g
  }


  object MyLabelConversion extends TypedLEdgeImplicits[MGraph, Relationship]
  import MyLabelConversion._


  val g: Graph[Person, LDiEdge] = this.generate()

  val p = g.get(Person("root"))
  g.nodes.map{
    node=>
    /*
    * Intellij IDEA infers the type as "N" when I choose "add type annotation" or try to access one of its properties.
But the real type here is Person
    * */
      val value = node.value
      value
  }.foreach(p=>println(p.toString))
}
