package issues

import util.parsing._
import input._
import combinator.RegexParsers

object SCL3979 extends RegexParsers {


  def failedMsg= """\[ FAILED \]""".r
  def startupMessage = """[\w\s\.]+""".r <~ failedMsg

  def getInstallResult(source: Reader[Char]): String = {
    parseAll(startupMessage, source) match {
      case Success(results, rest) => results
      case Failure(msg, rest)     => msg
    }
  }

  val logFile2 = """Starting MySQL Enterprise agent service...                 failed to start. [ FAILED ]"""
}
