package org.functionalkoans.forscala.support

object BlankValues {

  class ReplaceWithCorrectException extends Exception

  val __ = "Should be filled in"

  class ___ extends ReplaceWithCorrectException {
    override def toString() = "___"
  }

}


object Blankout {
  def blank[T](t: T): T = t
}

