package com.zac.tests

import geb.spock.GebSpec

class YahooOfDebugTest extends GebSpec {

  def "output debug log"() {
    when:
    go "http://www.yahoo.co.jp"

    then:
    waitFor{ title == "Yahoo! JAPAN"}
    $("input").each{
      println "name: " + it.getAttribute("name") +
          ", type: " + it.getAttribute("type") +
          ", value: " + it.getAttribute("value")
    }
  }
}