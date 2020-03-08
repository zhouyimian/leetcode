package com.km.WeeklyContest179;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Frog_Position_After_T_Seconds {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        double ans = 1.0;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0;i<=n;i++)
            graph.add(new ArrayList<>());
        for(int i = 0;i<edges.length;i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[] vis = new boolean[n+1];
        return func(vis, 1, graph, target, 0, t);
    }

    private double func(boolean[] vis, int cur, List<List<Integer>> graph, int target, int time, int t) {
        if(time == t) return cur == target ? 1 : 0;
        vis[cur] = true;
        double res = 0.0;
        boolean flag = false;
        int count = 0;
        List<Integer> next = graph.get(cur);
        for(int num:next){
            if(!vis[num])
                count++;
        }
        for(int num:next){
            if(!vis[num]){
                flag = true;
                res+=(func(vis,num,graph,target,time+1,t)/count);
            }
        }
        if(!flag) return cur==target?1:0;
        vis[cur] = false;
        return res;
    }

    public static void main(String[] args) {
        Frog_Position_After_T_Seconds test = new Frog_Position_After_T_Seconds();
        int[][] edges = {{1,2},{1,3},{1,7},{2,4},{2,6},{3,5}};
        System.out.println(test.frogPosition(7,edges,20,6));
    }
}
