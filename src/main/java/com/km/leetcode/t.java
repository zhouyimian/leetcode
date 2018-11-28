package com.km.leetcode;

public class t {

	public static void main(String[] args) {
		MapSum ms=new MapSum();
		ms.insert("apple", 3);
		System.out.println(ms.sum("ap"));
		ms.insert("apple", 2);
		System.out.println(ms.sum("ap"));

	}

}
