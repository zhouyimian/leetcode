package com.km.leetcode;

import java.util.HashSet;

public class Bitwise_ORs_of_Subarrays {
	public int subarrayBitwiseORs(int[] A) {
		HashSet<Integer> ans=new HashSet<>(),cur=new HashSet<>();
		for(int i=0;i<A.length;i++) {
			HashSet<Integer> cur2=new HashSet<>();
			cur2.add(A[i]);
			for(int j:cur) cur2.add(j|A[i]);
			ans.addAll(cur=cur2);
		}
		return ans.size();
	}
}
