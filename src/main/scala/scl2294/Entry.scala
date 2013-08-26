package scl2294

class Outter {
  class Inner
}

object GlobalOutter extends Outter {
}

object Entry extends App {
  val outter = new Outter
  val inner: outter.Inner = new outter.Inner
  val inner1: Outter#Inner = new outter.Inner // the plugin only issues error for this statement
  val inner2: Outter#Inner = new GlobalOutter.Inner
  val inner3: GlobalOutter.Inner = new GlobalOutter.Inner
}
