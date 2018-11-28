package com.km.leetcode;

import java.util.*;

public class Sum_III {
	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Set<List<Integer>> ans = new HashSet<List<Integer>>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		int length = map.keySet().size();
		Iterator it = map.keySet().iterator();
		int[][] value = new int[length][2];
		int count = 0;
		while (it.hasNext()) {
			int Key = (int) it.next();
			int Value = map.get(Key);
			value[count][0] = Key;
			value[count][1] = Value;
			count++;
		}
		for(int i=0;i<value.length;i++) {
			for(int j=i+1;j<value.length;j++) {
				if(value[i][0]>value[j][0]) {
					int t=value[i][0];value[i][0]=value[j][0];value[j][0]=t;
					t=value[i][1];value[i][1]=value[j][1];value[j][1]=t;
				}
			}
		}
		for (int i = 0; i < value.length; i++) {
			if (value[i][0] > 0)
				break;
			int j;
			if (value[i][1] == 1)
				j = i + 1;
			else
				j = i;
			for (; j < value.length; j++) {
				if (value[i][0] + value[j][0] > 0)
					break;
				else {
					int sum = Math.abs(value[i][0] + value[j][0]);
					if (map.containsKey(sum)) {
						boolean flag1 = map.get(sum) == 1 && ((value[j][0] == sum) || (value[i][0] == sum));
						boolean flag2 = map.get(sum) == 2 && value[i][0] == sum && value[j][0] == sum;
						if (flag1 == false && flag2 == false) {
							List<Integer> temp = new ArrayList<Integer>();
							temp.add(value[i][0]);
							temp.add(value[j][0]);
							temp.add(sum);
							Collections.sort(temp);
							ans.add(temp);
						}
					}

				}
			}
		}
		it = ans.iterator();
		while (it.hasNext()) {
			list.add((List<Integer>) it.next());
		}
		return list;
	}
	public static void main(String[] args) {
		int[] s= {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
		List<List<Integer>> list = threeSum(s);
		System.out.println(list.size());
		
	}
}
