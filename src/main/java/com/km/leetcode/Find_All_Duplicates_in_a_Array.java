package com.km.leetcode;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Find_All_Duplicates_in_a_Array {

	public static void main(String[] args) {
		Integer[] a= {4,3,2,7,8,2,3,1};
		Arrays.sort(a);
		ArrayList<Integer> list=new ArrayList<Integer>();
		int count=0;
		for(int i=0;i<a.length-1;i++) {
			if(a[i]==a[i+1]) {
				list.add(a[i]);
				i++;
			}
		}
		Iterator<Integer> it= list.iterator();
		while(it.hasNext()) {
			System.out.print(it.next());
		}
	}

}
