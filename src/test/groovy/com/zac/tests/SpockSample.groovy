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