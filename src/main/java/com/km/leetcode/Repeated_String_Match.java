package com.km.leetcode;

public class Repeated_String_Match {
	public int repeatedStringMatch(String A, String B) {
		int ans = 0;
	    StringBuilder sb = new StringBuilder();
	    while (sb.length() < B.length()) {
	        sb.append(A);
	        ans++;
	    }
	    if(sb.toString().contains(B)) return ans;
	    if(sb.append(A).toString().contains(B)) return ++ans;
	    return -1;
	}
}
