package com.km.leetcode;

import java.util.*;

public class Kdiff_Pairs_in_an_Array {
	public static int findPairs(int[] nums, int k) {
		if(k<0)
			return 0;
		int ans=0;
		Map<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
		}
		Iterator it = map.keySet().iterator();
		if (k == 0) {
			while(it.hasNext()) {
			int key = (int) it.next();
			int value = map.get(key);
			ans += value>1?1:0;
			}
			return ans;
		} else {
			while (it.hasNext()) {
				int key = (int) it.next();
				int value = map.get(key);
				ans += map.containsKey(key-k)==true?1:0;
				ans += map.containsKey(key+k)==true?1:0;
			}
			return ans / 2;
		}
	}
	public static void main(String[] args) {
		int[] nums= {3,1,4,1,5};
		System.out.println(findPairs(nums,0));
	}
}
