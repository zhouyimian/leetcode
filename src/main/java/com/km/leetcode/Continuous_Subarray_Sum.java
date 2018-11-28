package com.km.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Continuous_Subarray_Sum {
	public static boolean checkSubarraySum(int[] nums, int k) {
		Map<Integer,Integer> map=new HashMap<>();
		map.put(0, -1);
		int sum=0;
		for(int i=0;i<nums.length;i++) {
			sum+=nums[i];
			if (k != 0) sum %= k; 
			if(map.containsKey(sum)) {
				int pos=map.get(sum);
				if(i-pos>1)
					return true;
			}
			else{
				map.put(sum, i);
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int[] nums= {23,2,4,6,7};
		System.out.println(checkSubarraySum(nums,6));
	}
}
