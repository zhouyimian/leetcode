package com.km.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pyramid_Transition_Matrix {
	Map<String,List<String>> map=new HashMap<>();
	String[] ta;
	public boolean pyramidTransition(String bottom, List<String> allowed) {
		ta=new String[bottom.length()];
		ta[bottom.length()-1]=bottom;
		for(int i=0;i<allowed.size();i++) {
			String key=allowed.get(i).substring(0, 2);
			List<String> value=map.get(key);
			if(value==null) {
				List<String> list=new ArrayList<>();
				list.add(allowed.get(i).substring(2, 3));
				map.put(key, list);
			}
			else {
				value.add(allowed.get(i).substring(2, 3));
				map.put(key, value);
			}
		}
		return dfs(bottom.length()-1,bottom)
	}
	
}
