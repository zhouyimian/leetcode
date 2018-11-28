package com.km.leetcode;

public class Binary_Number_with_Alternating_Bits {
	public boolean hasAlternatingBits(int n) {
		String s=Integer.toBinaryString(n);
		for(int i=1;i<s.length();i++) {
			if(s.charAt(i)==s.charAt(i-1))
				return false;
		}
		return true;
	}
}
