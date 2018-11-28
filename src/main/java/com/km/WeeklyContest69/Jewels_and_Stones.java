package com.km.WeeklyContest69;

import java.util.HashMap;
import java.util.Map;

public class Jewels_and_Stones {
	public int numJewelsInStones(String J, String S) {
		Map<Character,Integer> map=new HashMap<>();
		int ans=0;
		for(int i=0;i<S.length();i++) {
			map.put(S.charAt(i), map.getOrDefault(S.charAt(i), 0)+1);
		}
		for(int i=0;i<J.length();i++) {
			ans+=map.getOrDefault(J.charAt(i), 0);
		}
		return ans;
		
	}
}
