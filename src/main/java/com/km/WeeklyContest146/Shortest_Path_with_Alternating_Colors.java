package com.km.WeeklyContest146;

import java.util.*;

public class Shortest_Path_with_Alternating_Colors {

    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        int[] ans = new int[n];
        List<Integer>[] graph = new ArrayList[n+n];
        for(int i = 0;i<n*2;i++)
            graph[i] = new ArrayList<>();
        for(int[] edge:red_edges){
            graph[edge[0]].add(n+edge[1]);
        }
        for(int[] edge:blue_edges) {
            graph[edge[0] + n].add(edge[1]);
        }
        Arrays.fill(ans,-1);
        boolean[] vis = new boolean[n*2];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        queue.offer(n);
        int dist = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i<size;i++){
                int v = queue.poll();
                if(vis[v]) continue;
                vis[v] = true;
                if(v<n&&ans[v]<0) ans[v] = dist;
                if(v>=n&&ans[v-n]<0) ans[v-n] = dist;
                for(int next:graph[v])
                    queue.offer(next);
            }
            dist++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] red = {{0,1},{1,2},{2,3},{3,4}};
        int[][] blue = {{1,2},{2,3},{3,1}};
        Shortest_Path_with_Alternating_Colors test = new Shortest_Path_with_Alternating_Colors();
        int[] res = test.shortestAlternatingPaths(5,red,blue);
        for(int num:res)
            System.out.println(num);
    }
}
