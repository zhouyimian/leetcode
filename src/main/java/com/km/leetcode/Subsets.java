package com.km.leetcode;

import java.util.*;

class Subsets {
	List<List<Integer>> ans=new ArrayList<>();
	public List<List<Integer>> subsets(int[] nums) {
		List<Integer> temp=new ArrayList<>();
		ans.add(new ArrayList<>());
		Catch(nums,0,true,temp);
		Catch(nums,0,false,temp);
		return ans;
	}
	void Catch(int[] nums,int num,boolean take,List temp) {
		if(num>=nums.length)
			return;
		List<Integer> list = new ArrayList<>();
		list.addAll(temp);
		if(take==true) {
			list.add(nums[num]);
			ans.add(list);
			Catch(nums,num+1,true,list);
			Catch(nums,num+1,false,list);
		}
		else {
			Catch(nums,num+1,true,temp);
			Catch(nums,num+1,false,temp);
		}
	}
}
