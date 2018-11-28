package com.km.WeeklyContest104;

import java.util.HashMap;
import java.util.Map;

public class x_of_a_kind_in_a_deck_of_cards {
	int Euclidean_nonRecursion(int m, int n) {
	    while (n != 0) {
	        int r = m % n;
	        m = n;
	        n = r;
	    }
	    return m;
	}
	public boolean hasGroupsSizeX(int[] deck) {
		Map<Integer,Integer> map=new HashMap<>();
		for(int num:deck) {
			map.put(num, map.getOrDefault(num, 0)+1);
		}
		int group_num=0;
		int minnum=Integer.MAX_VALUE;
		for(int key:map.keySet()) {
			if(map.get(key)==1)
				return false;
			minnum=minnum==Integer.MAX_VALUE?map.get(key):Math.min(minnum, Euclidean_nonRecursion(minnum,map.get(key)));
		}
		for(int key:map.keySet()) {
			if(map.get(key)%minnum!=0)
				return false;
			else
				group_num+=map.get(key)/minnum;
		}
		return minnum>=2?true:false;
	}

	public static void main(String[] args) {
		int[] num= {0,0,0,1,1,1,1,1,1,2,2,2,3,3,3};
		//System.out.println(hasGroupsSizeX(num));
		x_of_a_kind_in_a_deck_of_cards x=new x_of_a_kind_in_a_deck_of_cards();
		System.out.println(x.hasGroupsSizeX(num));
	}

}
