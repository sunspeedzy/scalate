package org.fusesource.scalate.util

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.fusesource.scalate.util.URIs._

/**
 * @version $Revision: 1.1 $
 */
@RunWith(classOf[JUnitRunner])
class URIsTest extends FunSuite with Logging {

  test("adding query argument to no query string") {
    expect("/foo?x=1") { uri("/foo", "x=1")}
  }

  test("adding query argument to query string") {
    expect("/foo?x=1&y=2") { uri("/foo?x=1", "y=2")}
  }

  test("adding query argument to existing query") {
    expect("/foo?x=1&y=2") { uriPlus("/foo", null, "x=1&y=2")}
    expect("/foo?x=1&y=2") { uriPlus("/foo", "", "x=1&y=2")}
    expect("/foo?x=1&y=2") { uriPlus("/foo", "x=1", "y=2")}
    expect("/foo?x=1&y=2") { uriPlus("/foo", "x=1", "x=1&y=2")}
    expect("/foo?x=1&y=2") { uriPlus("/foo", "x=1&y=2", "x=1&y=2")}
  }

  test("removing query argument to existing query") {
    expect("/foo?x=1&y=2") { uriMinus("/foo", "x=1&y=2", "foo=bar")}
    expect("/foo?x=1&y=2") { uriMinus("/foo", "x=1&y=2&z=3", "z=3")}
  }
}