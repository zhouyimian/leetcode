package com.km.problem11_20;

import java.util.*;

public class Letter_Combinations_of_a_Phone_Number {

	public List<String> letterCombinations(String digits) {
		char[][] reflect= {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
		if(digits.length()==0)
			return new ArrayList<>();
		List<StringBuilder> queue = new ArrayList<>();
		queue.add(new StringBuilder(""));

		for(int i = 0;i<digits.length();i++){
			int index = digits.charAt(i)-'0';
			List<StringBuilder> temp = new ArrayList<>();
			for(int j = 0;j<reflect[index].length;j++){
				for(int k = 0;k<queue.size();k++){
					StringBuilder sb = new StringBuilder(queue.get(k));
					sb.append(reflect[index][j]);
					temp.add(sb);
				}
			}
			queue.clear();
			queue.addAll(temp);
		}

		List<String> ans = new ArrayList<>();
		for(StringBuilder sb:queue){
			ans.add(sb.toString());
		}
		return ans;
	}
	public static void main(String[] args) {
		Letter_Combinations_of_a_Phone_Number test = new Letter_Combinations_of_a_Phone_Number();
		List<String> list=test.letterCombinations("23");
		for(String s:list) {
			System.out.println(s);
		}
	}
}
