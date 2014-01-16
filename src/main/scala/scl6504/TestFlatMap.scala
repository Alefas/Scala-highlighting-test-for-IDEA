package scl6504

import scala.collection.mutable.ArrayBuffer

class TestFlatMap {
  class Box[T](val value: T)

  class BoxBuilder[T] {
    def flatMapIterable[C[X] <: Iterable[X], N](f: T => Box[C[N]]): BoxBuilder[N] = new BoxBuilder[N]

    def flatMapIterable(x: String => String) = 123

    def toList = new Box(List.empty[T])
  }


  def test1() = {
    new BoxBuilder[String]().flatMapIterable[ArrayBuffer, Int]((v) => new Box(new ArrayBuffer[Int])).toList
  }

  def test2() = {
    new BoxBuilder[String]().flatMapIterable((v: String) => new Box(new ArrayBuffer[Int])).toList
  }
}
