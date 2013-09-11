package issues

object SCL5579 {
  object Main  extends App {
    val ab = new `A & B`
    ab.x
  }

  object Foo extends `D & E` {
    println(y)
  }
}
