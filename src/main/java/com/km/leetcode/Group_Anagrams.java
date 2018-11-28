package com.km.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Group_Anagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String,List<String>> map=new HashMap<>();
		List<List<String>> ans=new ArrayList<>();
		String[] s=new String[strs.length];
		for(int i=0;i<strs.length;i++) {
			char[] temp=strs[i].toCharArray();
			Arrays.sort(temp);
			s[i]=Arrays.toString(temp);
		}
		for(int i=0;i<strs.length;i++) {
			if(!map.containsKey(s[i])) {
				List<String> list=new ArrayList<>();
				list.add(strs[i]);
				map.put(s[i], list);
			}
			else {
				List<String> list=map.get(s[i]);
				list.add(strs[i]);
				map.put(s[i], list);
			}
		}
		Set<String> set=map.keySet();
		Iterator<String> it=set.iterator();
		while(it.hasNext()) {
			String key=(String) it.next();
			ans.add(map.get(key));
		}
		
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
