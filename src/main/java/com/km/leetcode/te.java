package com.km.leetcode;

public class te {

	public static void main(String[] args) {
		LFUCache lfu=new LFUCache(2);
		lfu.map.put(3, 1);
		lfu.map.put(2, 1);
		lfu.map.put(2, 2);
		lfu.map.put(4, 4);
		System.out.println(lfu.map.get(3));
		/*lfu.map.put(3,3);
		System.out.println(lfu.map.get(2));
		System.out.println(lfu.map.get(3));
		lfu.map.put(4,4);
		System.out.println(lfu.map.get(1));
		System.out.println(lfu.map.get(3));
		System.out.println(lfu.map.get(4));*/
	}

}
