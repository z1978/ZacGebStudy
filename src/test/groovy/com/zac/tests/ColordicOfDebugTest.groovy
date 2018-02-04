package com.zac.tests

import geb.spock.GebSpec

class ColordicOfDebugTest extends GebSpec {

	def "output debug log"() {
		when:
		go "https://www.colordic.org/"

		then:
		//    waitFor{ title == "Yahoo! JAPAN"}
		//    $("input").each{
		//      println "name: " + it.getAttribute("name") +
		//          ", type: " + it.getAttribute("type") +
		//          ", value: " + it.getAttribute("value")
		//    }

		$("td").each{
			println it
			println it.getAttribute("style")
			it.each{
				println it.getAttribute("style")
			}
			//	def mapProperties = t.getProperties()
			//	mapProperties.remove('class')//默认有自带class属性，移除减少数据传输量
			//	println(mapProperties)
			//	      println "name: " + it.getAttribute("name") +
			//	          ", type: " + it.getAttribute("type") +
			//	          ", value: " + it.getAttribute("value") +
			//	          ", style: " + it.getAttribute("style")

		}
	}
}