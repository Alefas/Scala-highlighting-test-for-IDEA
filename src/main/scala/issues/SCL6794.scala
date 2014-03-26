package issues

class SCL6794 {
  val x: (String, Int => Unit) = "" -> someFunction

  def someFunction(value: Int) {}
}
