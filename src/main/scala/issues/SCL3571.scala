package issues
import java.awt.{Dimension, Rectangle}

class SCL3571(val data: Array[Int], val dimension: Dimension, val cropping: Rectangle) {
  if ((cropping.width, cropping.height) == (0, 0)) {
    cropping.width = dimension.width
    cropping.height = dimension.height
  }
}
