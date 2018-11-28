package com.km.leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Isomorphic_Strings {
	public static boolean isIsomorphic(String s, String t) {

		Map<Character, List<Integer>> map1 = new LinkedHashMap<>();
		Map<Character, List<Integer>> map2 = new LinkedHashMap<>();
		if (s.length() != t.length())
			return false;
		int[] count = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			if (count[i] == 1)
				continue;
			else {
				List<Integer> templist = new ArrayList<>();
				templist.add(i);
				char c = s.charAt(i);
				for (int j = i + 1; j < s.length(); j++) {
					if (s.charAt(j) == c) {
						templist.add(j);
						count[j] = 1;
					}
				}
				map1.put(c, templist);
			}
		}
		count = new int[s.length()];

		for (int i = 0; i < t.length(); i++) {
			if (count[i] == 1)
				continue;
			else {
				List<Integer> templist = new ArrayList<>();
				templist.add(i);
				for (int j = i + 1; j < t.length(); j++) {
					if (t.charAt(j)==t.charAt(i)) {
						templist.add(j);
						count[j] = 1;
					}
				}
				map2.put(t.charAt(i), templist);
			}
		}

		if (map1.size() != map2.size())
			return false;
		Collection<List<Integer>> list1 = map1.values();
		Collection<List<Integer>> list2 = map2.values();
		Iterator it1 = list1.iterator();
		Iterator it2 = list2.iterator();
		while (it1.hasNext()) {
			List<Integer> l1 = (List<Integer>) it1.next();
			List<Integer> l2 = (List<Integer>) it2.next();
			if (!l1.containsAll(l2))
				return false;
		}

		return true;
	}
	public static void main(String[] args) {
		System.out.println(isIsomorphic("egg","add"));
	}
}
