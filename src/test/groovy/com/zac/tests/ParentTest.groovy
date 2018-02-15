package com.zac.tests

import com.zac.action.Child
import com.zac.action.Parent
import spock.lang.Specification
import spock.lang.Unroll

class ParentTest extends Specification {
	Parent sut

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

	def "Mock を使ってみる"() {
		given:
		Child child = Mock()
		1 * child.add(1, 2) >> 10
		1 * child.add(2, 3)
		child.add(3, 4)

		when:
		sut = new Parent(child)

		then:
		sut.add(1, 2) == 10 // ふるまいが置き換えられる
		sut.add(2, 3) == 0 // 5 じゃない。なにもしない振る舞いになる
		sut.add(3, 4) == 0 // 7 じゃない。なにもしない振る舞いになる
		sut.add(4, 5) == 0 // 9 じゃない。なにもしない振る舞いになる
	}

	def "Stub を使ってみる"() {
		given:
		Child child = Stub()
		child.add(1, 2) >> 10 // カーディナリティ（1 * 〜）はエラーになる

		when:
		sut = new Parent(child)

		then:
		sut.add(1, 2) == 10 // ふるまいが置き換えられる
		sut.add(2, 3) == 0 // 5 じゃない。なにもしない振る舞いになる
	}
	
	
	def "Spy を使ってみる"() {
		given:
		MockTestData mockTestData = new MockTestData()
		def mData = mockTestData.mockTestData()
		println mData
		
		Child child = Spy()
		1 * child.add(1, 2) >> mData
		1 * child.add(2, 3)

		when:
		sut = new Parent(child)

		then:
		sut.add(1, 2) == 99 // ふるまいが置き換えられる ＋ カーディナリティの検証
		sut.add(2, 3) == 5 // 実際に呼ばれる ＋ カーディナリティの検証
		sut.add(3, 4) == 7 // 実際によばれる
	}

	def cleanup() {
		println ("----- cleanup")
		println ("各featureメソッドの後に実行される")
	}

	def cleanupSpec() {
		println ("----- cleanupSpec")
		println ("最後のfeatureメソッドの後に1度だけ実行される")
	}
}