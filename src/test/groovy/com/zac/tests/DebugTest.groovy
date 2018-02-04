package com.zac.tests

import geb.spock.GebSpec

class DebugTest extends GebSpec {

  def "output debug log"() {
    when:
    go "http://www.yahoo.co.jp"
	
//	js.exec  "window.open('http://www.google.co.jp')"
//	js.exec "window.open('about:blank', '', '')"
//	var win = window.open(url, '_blank');
//	win.focus();
//	withWindow('childWindow') {
//		assert $('title').text() == 'child window'
//	} == null
	
    then:
    waitFor{ title == "Yahoo! JAPAN"}
    $("input").each{
      println "name: " + it.getAttribute("name") +
          ", type: " + it.getAttribute("type") +
          ", value: " + it.getAttribute("value")
    }
  }
}