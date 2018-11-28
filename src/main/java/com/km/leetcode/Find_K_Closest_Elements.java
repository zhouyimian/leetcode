package com.km.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Find_K_Closest_Elements {
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		Map<Integer,List<Integer>> diff=new TreeMap<>();
		List<Integer> ans=new ArrayList<>();
		for(int num:arr) {
			List<Integer> temp=diff.getOrDefault(Math.abs(num-x), new ArrayList<Integer>());
			temp.add(num);
			diff.put(Math.abs(num-x), temp);
		}
		Iterator it=diff.keySet().iterator();
		while(it.hasNext()) {
			int key=(int)it.next();
			List<Integer> temp=diff.get(key);
			if(temp.size()<=k) {
				ans.addAll(temp);
				k-=temp.size();
			}
			else {
				Collections.sort(temp);
				for(int i=0;i<k;i++)
					ans.add(temp.get(i));
				break;
			}
		}
		Collections.sort(ans);
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
