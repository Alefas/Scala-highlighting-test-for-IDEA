package issues

import scl5515.JavaPart

class SCL5515 extends JavaPart[Int] {
  override def z(m: JavaPart[Int]#M): Unit = {
    m.foo(123)
  }
}
