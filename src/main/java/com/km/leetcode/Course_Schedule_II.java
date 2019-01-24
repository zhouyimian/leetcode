package com.km.leetcode;

import java.util.*;

public class Course_Schedule_II {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> ans = new ArrayList<>();
        int[] input = new int[numCourses];
        int[] vis = new int[numCourses];
        int length = prerequisites.length;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0;i<numCourses;i++)
            graph.add(new ArrayList<>());
        Arrays.fill(input,0);
        Arrays.fill(vis,-1);
        for(int i = 0 ;i < length; i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            input[prerequisites[i][0]]++;
        }
        for(int i = 0;i<numCourses&&ans.size()<numCourses;i++){
            for(int j = 0;j<numCourses;j++){
                if(input[j] == 0&&vis[j] == -1){
                    ans.add(j);
                    vis[j] = 0;
                    for(int num:graph.get(j))
                        input[num]--;
                }
            }
        }
        if(ans.size()==numCourses){
            int[] temp = new int[numCourses];
            for(int i = 0;i<numCourses; i++)
                temp[i] = ans.get(i);
            return temp;
        }
        return new int[0];
    }

    public static void main(String[] args) {
        Course_Schedule_II test = new Course_Schedule_II();
        int[][] nums = {{1,0},{2,0},{3,1},{3,2}};
        for(int num:test.findOrder(4,nums))
            System.out.println(num);
    }
}
