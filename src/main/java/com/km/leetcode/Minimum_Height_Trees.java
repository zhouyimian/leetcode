package com.km.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Minimum_Height_Trees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        int[] input = new int[n];
        int[] output = new int[n];
        int[] vis = new int[n];
        int length = edges.length;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0;i<n;i++)
            graph.add(new ArrayList<>());
        Arrays.fill(input,0);
        Arrays.fill(output,0);
        Arrays.fill(vis,-1);
        for(int i = 0 ;i < length; i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
            input[edges[i][0]]++;
            input[edges[i][1]]++;
            output[edges[i][0]]++;
            output[edges[i][1]]++;
        }
        int deal = n;
        for(int i = 0;i<n&&ans.size()<n;i++){
            if(deal==2||deal==1){
                for(int j = 0;j<n;j++){
                    if(vis[j]==-1)
                        ans.add(j);
                }
                break;
            }else {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    if (vis[j] == -1 && input[j] == output[j] && input[j] == 1) {
                        temp.add(j);
                    }
                }
                deal -= temp.size();
                for (int index : temp) {
                    vis[index] = 1;
                    for (int num : graph.get(index)) {
                        input[num]--;
                        output[num]--;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Minimum_Height_Trees test = new Minimum_Height_Trees();
        int[][] nums = {{0,3},{1,3},{2,3},{4,3},{5,4}};
        for(int num:test.findMinHeightTrees(6,nums))
            System.out.println(num);
    }
}
