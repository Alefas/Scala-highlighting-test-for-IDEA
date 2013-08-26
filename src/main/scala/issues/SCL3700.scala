package issues

class SCL3700

trait Definition {
  type Inner
}

trait Logic[ T <: Definition ] {
  def doSomething( x: T#Inner )
}

class TestDefinition extends Definition {
  class Tester {
    def ping() { println( "ping" ) }
  }
  type Inner = Tester
}

class TestLogic extends Logic[ TestDefinition ] {       // TestLogic highlighted in red
def doSomething( x: TestDefinition#Tester ) {
  x.ping()
}
}
