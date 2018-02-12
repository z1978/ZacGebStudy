package com.zac.tests

import spock.lang.Specification
import spock.lang.Unroll

class TestingExceptionsWithDataTables extends Specification {
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

	def 'validate valid user'() {
		when:
		validateUser(user)

		then:
		noExceptionThrown()

		where:
		user << [
			new User(userName: 'tester'),
			new User(userName: 'joe')
		]
	}

	def 'validate invalid user'() {
		when:
		validateUser(user)

		then:
		def error = thrown(expectedException)
		error.message == expectedMessage

		where:
		user                     || expectedException | expectedMessage
		new User(userName: null) || Exception         | 'no userName'
		new User(userName: '')   || Exception         | 'no userName'
		null                     || Exception         | 'no user'
	}

	private validateUser(User user) {
		if (!user) throw new Exception('no user')
		if (!user.userName) throw new Exception('no userName')
	}

	class User {
		String userName
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