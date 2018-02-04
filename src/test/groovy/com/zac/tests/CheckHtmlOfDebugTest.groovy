package com.zac.tests

import geb.spock.GebSpec

class CheckHtmlOfDebugTest extends GebSpec {

  def "output debug log"() {
    when:
    go "http://www.yahoo.co.jp"

    then:
    waitFor{ title == "Yahoo! JAPAN"}
//    $("input").each{
//      println "name: " + it.getAttribute("name") +
//          ", type: " + it.getAttribute("type") +
//          ", value: " + it.getAttribute("value")
//    }
	def args = ""
	def applink = $('a')
	println applink
//	println $("#topicsboxbd").$("#topicsfb").$(".topicsindex").$("ul").$("li").$("a").getHref()
$("#topicsboxbd").$("#topicsfb").$(".topicsindex").each{
		args = it.getAttribute("ul")
		println args
	}
	println args.size()
	if (args.size() < 1) {
		printf("Please specify a folder or HTML file path...")
		return
	}
	
	def file = new File(args[0])
	if(file.isFile()) {
		if(!args[0].toLowerCase().endsWith(".html")) {
			return
		}
		checkHtml(file)
	} else if (file.isDirectory()) {
		def errorLinks = new HashMap<String, List<String>>()
		file.eachFileMatch( ~/.*\.html/, {
			checkHtml(it, errorLinks)
		})
		errorLinks.each {name, links ->
			println "file: " + name
			links.each {
				println "href:\t" + it
			}
		}
	}
  
  }
  
  
  
  void checkHtml(File file, HashMap<String, List<String>> errorlinks) {
	  def matches = file.text.findAll('href="([^#(http)].+?)("|#)')
	  def links = new ArrayList<String>()
	  matches.each {
		  def path = it - 'href="' - '"' - '#'
		  if(!new File(file.getParentFile(), path).exists()) {
			  links.add(path)
		  }
	  }
	  if(!links.isEmpty()) {
		  errorlinks.put(file.path, links)
	  }
  }
  
  
}