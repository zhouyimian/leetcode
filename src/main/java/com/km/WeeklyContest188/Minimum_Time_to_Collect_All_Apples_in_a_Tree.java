package com.km.WeeklyContest188;

import java.util.*;

public class Minimum_Time_to_Collect_All_Apples_in_a_Tree {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer,List<Integer>> tree = buildTree(edges);
        Set<Integer> visit = new HashSet<>();
        return help(0,tree,visit,hasApple);
    }

    private int help(int node, Map<Integer, List<Integer>> tree, Set<Integer> visit, List<Boolean> hasApple) {
        visit.add(node);
        int res = 0;
        for(int child:tree.get(node)){
            if(visit.contains(child))
                continue;
            else
                res+=help(child,tree,visit,hasApple);
        }
        if((res>0||hasApple.get(node))&&node!=0) res+=2;
        return res;
    }

    private Map<Integer, List<Integer>> buildTree(int[][] edges) {
        Map<Integer,List<Integer>> tree = new HashMap<>();
        for(int[] edge :edges){
            int from = edge[0];
            int to = edge[1];
            tree.putIfAbsent(from,new LinkedList<>());
            tree.putIfAbsent(to,new LinkedList<>());
            tree.get(from).add(to);
            tree.get(to).add(from);
        }
        return tree;
    }
}
