package com.zac.action;

public class Parent {
	Child child;

	Parent(Child child) {
		this.child = child;
	}

	int add(int a, int b) {
		return child.add(a, b);
	}

}