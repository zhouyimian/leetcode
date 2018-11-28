package com.km.leetcode;

import java.util.*;

public class Find_Smallest_Letter_Greater_Than_Target {
	public char nextGreatestLetter(char[] letters, char target) {
		Set<Character> set=new TreeSet<>();
		for(int i=0;i<letters.length;i++)
			set.add(letters[i]);
		Iterator it=set.iterator();
		while(it.hasNext()) {
			char c=(char) it.next();
			if(c>target)
				return c;
		}
		return letters[0];
	}
}
