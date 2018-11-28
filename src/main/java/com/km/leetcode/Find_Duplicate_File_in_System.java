package com.km.leetcode;

import java.util.*;

public class Find_Duplicate_File_in_System {
	public static List<List<String>> findDuplicate(String[] paths) {
		List<List<String>> ans=new ArrayList<>();
		Map<String,Set<String>> map=new HashMap<>();
		for(int i=0;i<paths.length;i++) {
			String[] temp=paths[i].split(" ");
			for(int j=1;j<temp.length;j++) {
				int index=temp[j].indexOf('(');
				String filename=temp[0]+"/"+temp[j].substring(0,index);
				String contest=temp[j].substring(index);
				Set<String> filenames=map.getOrDefault(contest, new HashSet<String>());
				filenames.add(filename);
			}
		}
		for(String key:map.keySet()) {
			if(map.get(key).size()>1) {
				ans.add(new ArrayList<String>(map.get(key)));
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		String[] s= {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
		findDuplicate(s);
	}
}
