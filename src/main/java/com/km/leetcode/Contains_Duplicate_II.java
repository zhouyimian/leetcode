package com.km.leetcode;

import java.util.*;

public class Contains_Duplicate_II {
	/*public static boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			int j=map.getOrDefault(nums[i], -1);
			map.put(nums[i], i);
			if(j==-1) {
				continue;
			}
			if(Math.abs(i-j)<=k)
				return true;
		}
		return false;
	}*/
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if(t<0)
			return false;
		Map<Integer,List<Integer>> map=new TreeMap<>();
		for(int i=0;i<nums.length;i++) {
			if(map.get(nums[i])==null) {
				List<Integer> temp=new ArrayList<Integer>();
				temp.add(i);
				map.put(nums[i], temp);
			}
			else {
				List<Integer> temp=map.get(nums[i]);
				if(Math.abs(temp.get(temp.size()-1)-i)<=k)
					return true;
				temp.add(i);
				map.put(nums[i], temp);
			}
		}
		Set set=map.keySet();
		List<Integer> temp=new ArrayList<>();
		temp.addAll(set);
		for(int i=0;i<temp.size();i++) {
			for(int j=i+1;j<temp.size();j++) {
				if(Math.abs((long)temp.get(i)-(long)temp.get(j))>t)
						break;
				else {
					if(check(map.get(temp.get(i)),map.get(temp.get(j)),k)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	static boolean check(List<Integer> temp1,List<Integer> temp2,int k) {
		Iterator it1=temp1.iterator();
		Iterator it2=temp2.iterator();
		while(it1.hasNext()) {
			it2=temp2.iterator();
			int num1=(int) it1.next();
			while(it2.hasNext()) {
				int num2=(int) it2.next();
				if(Math.abs(num1-num2)<=k)
					return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int[] n= {1,0,1,1};
		System.out.println(containsNearbyAlmostDuplicate(n,1,0));
	}
}
