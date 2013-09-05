package issues

object TypeAliases {
  class A[A, B]
  type Z[T] = A[T, T]

  val z: Z[Int] = new Z[Int]
}
