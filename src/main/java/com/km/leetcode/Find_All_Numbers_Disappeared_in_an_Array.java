package com.km.leetcode;

import java.util.ArrayList;
import java.util.Iterator;

public class Find_All_Numbers_Disappeared_in_an_Array {

	public static void main(String[] args) {
		int[] nums= {4,3,2,7,8,2,3,1};
		ArrayList<Integer> list=new ArrayList<Integer>(nums.length);
		for(int i=0;i<nums.length;i++) {
			int temp=Math.abs(nums[i])-1;
			if(nums[temp]>0)
				nums[temp]=-nums[temp];
			}
		for(int i=0;i<nums.length;i++) {
			if(nums[i]>0)
				list.add(i+1);
		}
		Iterator<Integer> it2=list.iterator();
		while(it2.hasNext()) {
			System.out.println(it2.next());
		}
	}

}
