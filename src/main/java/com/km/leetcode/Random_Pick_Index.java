package com.km.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Random_Pick_Index {
	Map<Integer,List<Integer>> map;
	
	
	public Random_Pick_Index(int[] nums) {
		map=new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			if(map.get(nums[i])==null) {
				List<Integer> list=new ArrayList<>();
				list.add(i);
				map.put(nums[i], list);
			}
			else {
				List<Integer> list=map.get(nums[i]);
				list.add(i);
				map.put(nums[i], list);
			}
		}
	}
	public int pick(int target) {
		Random rand = new Random();
		int ans=0;
		List<Integer> list=map.get(target);
		return list.get(rand.nextInt(list.size()));
	}
}
