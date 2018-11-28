package com.km.WeeklyContest87;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Hand_of_Straights {
	public static boolean isNStraightHand(int[] hand, int W) {
		if (hand.length % W != 0)
			return false;
		Map<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < hand.length; i++) {
			map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
		}
		Set<Integer> set = map.keySet();
		Iterator<Integer> it = set.iterator();
		while (it.hasNext()) {
			int key = it.next();
			int value=map.get(key);
			if (map.get(key) == null || map.get(key) == 0)
				continue;
			for (int i = 0; i < value; i++) {
				for (int j = 0; j < W; j++) {
					Integer count = map.get(key + j);
					if (count == null || count == 0) {
						System.out.println(key+j);
						return false;
					}
					else
						map.put(key + j, map.get(key + j) - 1);
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[] hand = {1,2,3,6,2,3,4,7,8};
				System.out.println(isNStraightHand(hand, 3));
	}
}
