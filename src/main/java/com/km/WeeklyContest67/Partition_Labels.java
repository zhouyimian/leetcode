package com.km.WeeklyContest67;

import java.util.ArrayList;
import java.util.List;

public class Partition_Labels {
	static List<Integer> ans = new ArrayList<>();

	public static List<Integer> partitionLabels(String S) {
		int temp = 0;
		for (int i = 0; i < S.length();i=temp) {
			for (int j = i + 1; j <= S.length(); j++) {
				temp = j;
				StringBuilder sb = new StringBuilder(S.substring(i, j));
				if (check(sb, j, S)) {
					ans.add(j - i);
					break;
				}
				
			}
		}
		return ans;
	}

	static boolean check(StringBuilder sb, int j, String s) {
		String temp = s.substring(j);
		for (int i = 0; i < sb.length(); i++) {
			if (temp.indexOf(sb.charAt(i)) != -1)
				return false;
		}
		return true;

	}

	public static void main(String[] args) {
		String s = "ababcbacadefegdehijhklij";
		List<Integer> list=partitionLabels(s);
		for(int i:list) {
			System.out.println(i);
		}
	}
}
