package scl6145

class CheckedException extends Exception
class ScalaPart {
  @throws[CheckedException]
  def foo() {
    throw new CheckedException
  }
}
