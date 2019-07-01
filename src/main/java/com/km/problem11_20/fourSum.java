package com.km.problem11_20;

import java.util.*;

public class fourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> ans=new ArrayList<>();
		Arrays.sort(nums);
		if(nums.length<4)
			return ans;
		if(nums[nums.length-1]*4<target||nums[0]*4>target)
			return ans;
		for(int i=0;i<nums.length-3;i++) {
			if(nums[i]+nums[nums.length-1]+nums[nums.length-2]+nums[nums.length-3]<target)
				continue;
			if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target)
				break;
			if(i>0&&nums[i]==nums[i-1])
				continue;
			for(int j=i+1;j<nums.length-2;j++) {
				if(nums[i]+nums[j]+nums[nums.length-1]+nums[nums.length-2]<target)
					continue;
				if(nums[i]+nums[j]+nums[j+1]+nums[j+2]>target)
					break;
				if(j>i+1&&nums[j]==nums[j-1])
					continue;
				int start=j+1;
				int end=nums.length-1;
				while(start<end) {
					int sum=nums[i]+nums[j]+nums[start]+nums[end];
					if(sum==target) {
						ans.add(Arrays.asList(nums[i],nums[j],nums[start],nums[end]));
						while(start<end&&nums[start]==nums[start+1]) start++;
						while(start<end&&nums[end]==nums[end-1]) end--;
						start++;
						end--;
					}
					else if(sum<target)
						start++;
					else
						end--;
				}
			}
		}
		return ans;
	}
}
