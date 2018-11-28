package com.km.WeeklyContest99;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Groups_of_Special_Equivalent_Strings {
	public static int numSpecialEquivGroups(String[] A) {
		String[] target=new String[A.length];
		Set<String> set=new HashSet<>();
		for(int i=0;i<A.length;i++) {
			StringBuilder sb1=new StringBuilder();
			StringBuilder sb2=new StringBuilder();
			for(int j=0;j<A[i].length();j++) {
				if(j%2==0)
					sb1.append(A[i].charAt(j));
				else
					sb2.append(A[i].charAt(j));
			}
			char[] s1=sb1.toString().toCharArray();
			char[] s2=sb2.toString().toCharArray();
			Arrays.sort(s1);
			Arrays.sort(s2);
			target[i]=Arrays.toString(s1)+"-"+Arrays.toString(s2);
			set.add(target[i]);
		}
		return set.size();
	}
	public static void main(String[] args) {
		String[] A= {"a","b","c","a","c","c"};
		System.out.println(numSpecialEquivGroups(A));
	}
}
