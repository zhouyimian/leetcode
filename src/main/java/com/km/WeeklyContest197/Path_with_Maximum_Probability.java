package com.km.WeeklyContest197;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Path_with_Maximum_Probability {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer,Map<Integer,Double>> graph = new HashMap<>();
        for(int i = 0;i<n;i++)
            graph.put(i,new HashMap<>());
        int size = edges.length;
        for(int i = 0;i<size;i++){
            int from = edges[i][0];
            int to = edges[i][1];
            graph.get(from).put(to,succProb[i]);
            graph.get(to).put(from,succProb[i]);
        }
        double[] pro = new double[n];
        Map<Integer,Double> queue = new HashMap<>();
        queue.put(start,1.0);
        while (!queue.isEmpty()){
            Map<Integer,Double> temp = new HashMap<>();
            for(Map.Entry<Integer,Double> entry:queue.entrySet()){
                int cur = entry.getKey();
                double gl = entry.getValue();
                Map<Integer,Double> next = graph.get(cur);
                for(Map.Entry<Integer,Double> nextMap:next.entrySet()){
                    int nextIndex = nextMap.getKey();
                    double nextgl = nextMap.getValue();
                    if(nextgl*gl>pro[nextIndex]){
                        pro[nextIndex]=nextgl*gl;
                        temp.put(nextIndex,pro[nextIndex]);
                    }
                }
            }
            queue = temp;
        }
        return pro[end];
    }

    public static void main(String[] args) {
        Path_with_Maximum_Probability test = new Path_with_Maximum_Probability();
        int[][] edges = {{0,1},{1,2},{0,2}};
        double[] succProb = {0.5,0.5,0.2};
        System.out.println(test.maxProbability(3,edges,succProb,0,2));
    }
}
