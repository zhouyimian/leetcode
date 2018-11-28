package com.km.leetcode;

import java.util.*;

public class Happy_Number {
	public static boolean isHappy(int n) {
		Map<Integer,Integer> map=new HashMap<>();
		int num=n;
		do {
			map.put(num, 1);
			num=deal(num);
		}while(!map.containsKey(num)&&num!=1);
		if(num==1)
			return true;
		return false;
	}
	static int deal(int num) {
		int count=0;
		while(num!=0) {
			count+=(num%10)*(num%10);
			num/=10;
		}
		return count;
	}
	public static void main(String[] args) {
		System.out.println(isHappy(19));
	}
}
