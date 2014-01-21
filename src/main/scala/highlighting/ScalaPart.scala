package highlighting

import java.util

class ScalaPart {
  val javaPart: JavaPart[String] = new JavaPart[String]

  javaPart.getData(new util.ArrayList[Int]())
}
