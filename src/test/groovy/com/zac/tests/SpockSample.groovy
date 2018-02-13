package com.zac.tests

import spock.lang.Specification
import spock.lang.Unroll

class SpockSample extends Specification {
	def setupSpec() {
		println ("----- setupSpec")
		println ("テストクラス内で一度きりの初期化")
		println ("最初のfeatureメソッドの前に1度だけ実行される")
	}

	def setup() {
		println ("----- setup")
		println ("テストケースごとの初期化")
		println ("各featureメソッドの前に実行される")
	}

	// @Unroll 書くならここに付ける
	def "何かのテスト"() {
		setup:
		println ("何かの初期化")

		def a = new String[4]
		def objs = new Object[3]

		a[0] = 'a'
		a[1] = 'b'
		a[2] = 'c'
		a[3] = 'd'

		a.each{ println it }
		for(it in a)
		{
			println it
		}

		//定义一个空集合
		def m=[:]
		//设置集合的内容，其中name，age为key
		m.name="Lucy"
		m.age=16
		m.height=165
		//这种方式也可以向map中添加元素
		m.put("sex","女")
		//取得集合的内容（单个）
		println m.get("name")
		m.each { it ->
			println it.key+","+it.value
		}
		//删除集合元素
		m.remove("height")
		println m.get("sex")
		println m.get("height")

		println "=================数组的使用[看起来和集合差不多]================="
		//数组的使用
		def str=["a", "b", "c"]
		println str[0]
		for(item in str){
			println item
		}
		def str2=["8", "5", "2", 7] as Integer[]
		println str2.sum()
		println str2.sort().reverse()

		// list2string string2list
		List list1 = ['a', 'b', 'c', 'd']
		def strs1 = list1 as String[]
		println strs1[0]

		def strs2 = ['a', 'b', 'c', 'd'] as String[]
		List list2 = strs2.toList()
		println list2.get(0)

		def strs3 = ['a', 'b', 'c', 'd'] as String[]
		List list3 = strs3 as List
		println list3.get(0)

		expect:
		println ("何らかの期待値")

		when:
		println ("何らかの条件")

		then:
		println ("モックメソッドの呼び出し回数確認など")

		cleanup:
		println ("後始末(あれば)")
	}

	def cleanup() {
		println ("----- cleanup")
		println ("各featureメソッドの後に実行される")
	}

	def cleanupSpec() {
		println ("----- cleanupSpec")
		println ("最後のfeatureメソッドの後に1度だけ実行される")
	}

	//
	def "length of Spock's and his friends' names"() {
		expect:
		name.size() == length

		where:
		name     | length
		"Spock"  | 5
		"Kirk"   | 4
		"Scotty" | 6
	}

	@Unroll
	def "このテストは実行できます"() {
		expect:
		expectedValue == parameterB - parameterA

		where:
		expectedValue || parameterA | parameterB
		1             || 2          | 3
		2             || 2          | 1
	}

	def "All ProductBacklogItem should be sorted by Priority"() {
		given: "Product Backlog has 3 PBIs"
		when: "Product Owner add 1 PBI into Product Backlog"
		then: "All PBI is sorted by Priority "
		(PB + PBI).sort().last() == "c"
		where:
		PB              | PBI
		["a", "b", "c"]| "bb"
		["a", "b", "c"]| "cc"
	}
	def "High Priority ProductBacklogItems should be estimated"() {
		given: "Product Backlog has 3 PBIs"
		when: "Product Owner add 1 PBI into Product Backlog"
		then: "Half of All PBIs is estimated"
		where:
		PB              | PBI
		["a":1, "b":null, "c":null] | ["ab":5]
		["a":1, "b":null, "c":null] | ["ab":5]
	}
}