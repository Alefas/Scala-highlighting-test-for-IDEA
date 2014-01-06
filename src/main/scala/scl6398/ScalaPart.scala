package scl6398

import scala.annotation.varargs

class ScalaPart {
  @varargs
  def foo(x: String*) = 123
}