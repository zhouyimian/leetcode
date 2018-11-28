package com.km.WeeklyContest66;

import java.util.HashMap;
import java.util.Map;

public class Find_Anagram_Mappings {
	public int[] anagramMappings(int[] A, int[] B) {
		int[] ans=new int[A.length];
		Map<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<B.length;i++) {
			map.put(B[i], i);
		}
		for(int i=0;i<A.length;i++) {
			ans[i]=map.get(A[i]);
		}
		return ans;
	}
}
