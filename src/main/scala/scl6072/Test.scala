package scl6072

import spray.routing.HttpService

trait Test extends HttpService {
  path("bar" / Segment / Segment) {
    (param1, param2) =>
      get {
        complete("Hello world.")
      }
  }
}
