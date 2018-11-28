package com.km.leetcode;

import java.util.*;

public class Letter_Combinations_of_a_Phone_Number {
	static List<String> ans=new ArrayList<>();
	static char[][] reflect= {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
	public static List<String> letterCombinations(String digits) {
		if(digits.length()==0)
			return ans;
		dfs(digits,"");
		return ans;
	}
	static void dfs(String s,String combina) {
		int num=Integer.parseInt(s.substring(0, 1));
		if(s.length()==1) {
			if(num==7||num==9) {
				for(int i=0;i<4;i++) {
					ans.add(combina+reflect[num][i]);
				}
			}
			else {
				if(num==1)
					ans.add(combina);
				else {
					for (int i = 0; i < 3; i++) {
						ans.add(combina+reflect[num][i]);
					}
				}
			}
		}
		else {
			if(num==7||num==9) {
				for(int i=0;i<4;i++) {
					dfs(s.substring(1),combina+reflect[num][i]);
				}
			}
			else {
				if(num==1)
					dfs(s.substring(1), combina);
				else {
					for (int i = 0; i < 3; i++) {
						dfs(s.substring(1), combina + reflect[num][i]);
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		List<String> list=letterCombinations("8");
		for(String s:list) {
			System.out.println(s);
		}
	}
}
