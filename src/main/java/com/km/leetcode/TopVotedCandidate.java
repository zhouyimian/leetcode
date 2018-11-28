package com.km.leetcode;

import java.util.TreeMap;

public class TopVotedCandidate {
	public TreeMap<Integer, Integer> tm = new TreeMap<>();
    public TopVotedCandidate(int[] persons, int[] times) {
        int[] count = new int[persons.length];
        for (int i = 0, max = -1; i < times.length; ++i) {
            ++count[persons[i]];
            if (max <= count[persons[i]]) {
            	max=count[persons[i]];
                tm.put(times[i], persons[i]);
            }
        }
    }
    public int q(int t) {
        return tm.floorEntry(t).getValue();
    }
	public static void main(String[] args) {
		int[] persons= {0,0,0,0,1};
		int[] times= {0,6,39,52,75};
		TopVotedCandidate test=new TopVotedCandidate(persons,times);
		System.out.println(test.q(99));
	}
}
