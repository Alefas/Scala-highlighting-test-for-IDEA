package issues

/**
 * Created by Alexander.Podkhalyuz on 23.01.14.
 */
object SCL6561 {
  class aliasbug {
    type Bar[Y, Z] = aliasbug.Foo[Int, Y, Z]

  }

  object aliasbug {
    trait Foo[X, Y, Z]
  }


  object Main {
    def main(args : Array[String]) = {
      val x = new aliasbug
      // the [ and ] are highlighted red here with
      // "wrong number of type paramters. Expected: 3, actual: 2"
      val u: x.Bar[String, Double] = new x.Bar[String, Double] {

      }
    }
  }
}
