package com.km.WeeklyContest173;

import java.util.*;

public class Find_the_City_With_the_Smallest_Number_of_Neighbors_at_a_Threshold_Distance {
    class Path{
        int cur;
        int remainDistinct;
        public Path(int cur, int remainDistinct) {
            this.cur = cur;
            this.remainDistinct = remainDistinct;
        }
    }
    int ansid = 0;
    int min_visit_numbers = Integer.MAX_VALUE;
    List<List<Integer>> graph = new ArrayList<>();
    Map<String,Integer> distincts = new HashMap<>();
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        for(int i = 0;i<n;i++)
            graph.add(new ArrayList<>());
        buildGraph(edges);
        for(int i = 0;i<n;i++){
            int numbers = BFS(i,distanceThreshold,n);
            if(numbers<=min_visit_numbers){
                min_visit_numbers = numbers;
                ansid = i;
            }
        }
        return ansid;
    }

    private int BFS(int source,int distanceThreshold,int maxSize) {
        List<Integer> canGo = graph.get(source);
        Set<String> node = new HashSet<>();
        Set<Integer> visit = new HashSet<>();
        List<Path> queue = new ArrayList<>();

        visit.add(source);
        node.add(source+"-"+distanceThreshold);
        for(int i = 0;i<canGo.size();i++){
            int distinct = distincts.get(source+"-"+canGo.get(i));
            if(distinct<=distanceThreshold){
                Path path = new Path(canGo.get(i),distanceThreshold-distinct);
                queue.add(path);
                node.add(canGo.get(i)+"-"+(distanceThreshold-distinct));
                visit.add(canGo.get(i));
            }
        }
        while (queue.size()!=0){
            if(visit.size()==maxSize)
                return maxSize;
            List<Path> temp = new ArrayList<>();
            for(int i = 0;i<queue.size();i++){
                Path cur = queue.get(i);
                List<Integer> nextGo = graph.get(cur.cur);
                for(int j = 0;j<nextGo.size();j++){
                    int distinct = distincts.get(cur.cur+"-"+nextGo.get(j));
                    if(cur.remainDistinct<distinct||node.contains(nextGo.get(j)+"-"+(cur.remainDistinct-distinct)))
                        continue;
                    else{
                        visit.add(nextGo.get(j));
                        node.add(nextGo.get(j)+"-"+(cur.remainDistinct-distinct));
                        temp.add(new Path(nextGo.get(j),cur.remainDistinct-distinct));
                    }
                }
            }
            queue.clear();
            queue.addAll(temp);
        }
        return visit.size();
    }

    private void buildGraph(int[][] edges) {
        for(int i = 0;i<edges.length;i++){
            int from = edges[i][0];
            int to = edges[i][1];
            int distinct = edges[i][2];
            graph.get(from).add(to);
            graph.get(to).add(from);
            distincts.put(from+"-"+to,distinct);
            distincts.put(to+"-"+from,distinct);
        }
    }

    public static void main(String[] args) {
        Find_the_City_With_the_Smallest_Number_of_Neighbors_at_a_Threshold_Distance test = new Find_the_City_With_the_Smallest_Number_of_Neighbors_at_a_Threshold_Distance();
        int[][] nums = {{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}};
        System.out.println(test.findTheCity(5,nums,2));
    }
}
