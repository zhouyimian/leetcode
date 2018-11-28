package com.km.leetcode;

import java.util.*;

public class Combination_Sum_III {
	 List<List<Integer>> ans;
	 List temp;
	 int count;
	 int value;
	public  List<List<Integer>> combinationSum3(int k, int n) {
		ans=new ArrayList<List<Integer>>();
		temp=new ArrayList<>();
		count=k;
		value=n;
		for(int i=1;i<=9;i++) {
			temp.add(i);
			search(2,i+1);
			temp.remove(0);
		}
		return ans;
	}
	 void search(int number,int start) {
		if(number==(count+1)) {
			int sum=0;
			Iterator it=temp.iterator();
			while(it.hasNext()) {
				sum+=(int)it.next();
			}
			if(sum==value) {
				List<Integer> list=new ArrayList<>();
				list.addAll(temp);
				ans.add(list);
			}
			return;
		}
		else {
			for(int i=start;i<=9;i++) {
				temp.add(i);
				search(number+1,i+1);
				temp.remove(number-1);
			}
		}
	}
}
