package com.km.WeeklyContest155;

import java.util.*;

public class Smallest_String_With_Swaps {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        StringBuilder sb = new StringBuilder();
        int[] parent = new int[s.length()];
        for(int i = 0;i<s.length();i++)
            parent[i] = i;
        for(int i = 0;i<pairs.size();i++){
            int from = pairs.get(i).get(0);
            int to = pairs.get(i).get(1);
            int parentA = findParent(from,parent);
            int parentB = findParent(to,parent);
            if(parentA!=parentB){
                parent[parentB] = parent[parentA];
            }
        }
        List<PriorityQueue<Character>> list = new ArrayList<>();
        for(int i = 0;i<s.length();i++)
            list.add(new PriorityQueue<>((o1, o2) -> o1-o2));
        for(int i = 0;i<s.length();i++) {
            int p = findParent(i,parent);
            list.get(p).add(s.charAt(i));
        }
        for(int i = 0;i<s.length();i++) {
            int p = findParent(i,parent);
            sb.append(list.get(p).poll());
        }
        return sb.toString();
    }

    private int findParent(int from, int[] parent) {
        while (from!=parent[from]){
            parent[from] = parent[parent[from]];
            from = parent[from];
        }
        return from;
    }

    public static void main(String[] args) {
        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(Arrays.asList(8,6));
        pairs.add(Arrays.asList(3,4));
        pairs.add(Arrays.asList(5,2));
        pairs.add(Arrays.asList(5,5));
        pairs.add(Arrays.asList(3,5));
        pairs.add(Arrays.asList(7,10));
        pairs.add(Arrays.asList(6,0));
        pairs.add(Arrays.asList(10,0));
        pairs.add(Arrays.asList(7,1));
        pairs.add(Arrays.asList(4,8));
        pairs.add(Arrays.asList(6,2));
        Smallest_String_With_Swaps t = new Smallest_String_With_Swaps();
        System.out.println(t.smallestStringWithSwaps("vbjjxgdfnru",pairs));
    }
}
//""
//[[8,6],[3,4],[5,2],[5,5],[3,5],[7,10],[6,0],[10,0],[7,1],[4,8],[6,2]]
