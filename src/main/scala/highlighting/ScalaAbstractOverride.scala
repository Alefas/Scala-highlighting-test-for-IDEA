package highlighting

trait K {
  def s(): Int
}

trait Z extends K {
  abstract override def s(): Int = {
    super.s() + 1
  }
}

class ScalaAbstractOverride extends AbstractOverride with Z {

}
