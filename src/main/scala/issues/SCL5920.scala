import scala.collection.mutable

object SCL5920 {
  type MyHM = mutable.HashMap[Int, Int]

  val tuple: (Int, Int) = null
  def add(map: MyHM): MyHM = map += tuple
}