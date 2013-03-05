package org.functionalkoans.forscala.support

import org.scalatest._
import org.scalatest.events.Event
import org.scalatest.events.TestSucceeded
import scala.Some

trait KoanSuite extends FunSuite {
  protected override def runTests(testName: Option[String], args: Args): Status = {
    args match {
      case Args(reporter, stopper, filter, configMap, distributor, tracker, _, _, _, _) =>
        if (testName == null)
          throw new NullPointerException("testName was null")
        if (reporter == null)
          throw new NullPointerException("reporter was null")
        if (stopper == null)
          throw new NullPointerException("stopper was null")
        if (filter == null)
          throw new NullPointerException("filter was null")
        if (configMap == null)
          throw new NullPointerException("configMap was null")
        if (distributor == null)
          throw new NullPointerException("distributor was null")
        if (tracker == null)
          throw new NullPointerException("tracker was null")

        class KoanReporter(wrappedReporter: Reporter) extends Reporter {
          var succeeded = false

          override def apply(event: Event) = {
            event match {
              case e: TestSucceeded => succeeded = true
              case _ =>
            }
            wrappedReporter(event)
          }
        }

        // If a testName is passed to run, just run that, else run the tests returned
        // by testNames.
        testName match {
          case Some(tn) => runTest(tn, new Args(reporter, stopper, filter, configMap, tracker = tracker))
          case None =>
            val tests = testNames.iterator
            var failed = false
            for (test <- tests) {
              if (failed == false) {
                val koanReporter = new KoanReporter(reporter)
                runTest(test, new Args(koanReporter, stopper, filter, configMap, tracker = tracker))
                failed = !koanReporter.succeeded
              }
            }
            if (failed) FailedStatus
            else SucceededStatus
        }
      case _ => SucceededStatus
    }
  }

  def koan(name: String)(fun: => Unit) = test(name.stripMargin)(fun)
}
