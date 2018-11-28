package com.km.leetcode;

import java.util.*;

public class Open_the_Lock {
	public int openLock(String[] deadends, String target) {
		List<String> list = new ArrayList<>();
		for (String s : deadends) {
			list.add(s);
		}
		if (list.contains("0000"))
			return -1;
		if (target.equals("0000"))
			return 0;
		int ans = 1;
		Queue<String> queue = new ArrayDeque<>();
		queue.add("0000");
		Map<String, Integer> map = new HashMap<>();
		map.put("0000", 1);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String s = queue.poll();
				List<String> temp = getNext(s);
				for (String str : temp) {
					if (map.containsKey(str) || list.contains(str))
						continue;
					else {
						if (str.equals(target)) {
							return ans;
						}
						queue.add(str);
						map.put(str, 1);
					}
				}
			}
			ans++;
		}
		return -1;
	}

	List<String> getNext(String s) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			StringBuilder sb = new StringBuilder(s);
			char c;
			if (s.charAt(i) == '0') {
				c = '9';
			} else {
				c = (char) (s.charAt(i) - 1);
			}
			sb.setCharAt(i, c);
			list.add(new String(sb));
			if (s.charAt(i) == '9') {
				c = '0';
			} else {
				c = (char) (s.charAt(i) + 1);
			}
			sb.setCharAt(i, (char) c);
			list.add(new String(sb));
		}
		return list;
	}

	public static void main(String[] args) {
		System.out.println();
	}
}
