package com.km.WeeklyContest77;

import java.util.HashSet;
import java.util.Set;

public class Unique_Morse_Code_Words {
	public int uniqueMorseRepresentations(String[] words) {
		String[] ant= {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
		Set<String> set=new HashSet<>();
		for(String s:words) {
			StringBuilder sb=new StringBuilder();
			for(int i=0;i<s.length();i++) {
				sb.append(ant[s.charAt(i)-'a']);
			}
			set.add(new String(sb));
		}
		return set.size();

	}
}
