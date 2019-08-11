package com.km;

import java.util.*;

public class AppTest2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int i = 0;i<numCourses;i++)
            graph.put(i,new ArrayList<>());
        int[] count = new int[numCourses];
        for(int i = 0;i<prerequisites.length;i++){
            List<Integer> list = graph.get(prerequisites[i][1]);
            list.add(prerequisites[i][0]);
            graph.put(prerequisites[i][1],list);
            count[prerequisites[i][0]]++;
        }
        List<Integer> queue = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for(int i = 0;i<numCourses;i++) {
            if (count[i] == 0) {
                queue.add(i);
            }
        }
        result.addAll(queue);
        while (queue.size()!=0){
            List<Integer> temp = new ArrayList<>();
            for(int i = 0;i<queue.size();i++){
                int cur = queue.get(i);
                List<Integer> course = graph.get(cur);
                for(int j = 0;j<course.size();j++){
                    count[course.get(j)]--;
                    if(count[course.get(j)]==0) {
                        temp.add(course.get(j));
                    }
                }
            }
            queue.clear();
            queue.addAll(temp);
            result.addAll(queue);
        }
        if(result.size()==numCourses){
            int[] ans = new int[numCourses];
            for(int i = 0;i<numCourses;i++)
                ans[i] = result.get(i);
            return ans;
        }
        return new int[0];
    }

    public static void main(String[] args) {

        int[] tree = {0, 1, 2, 2};
        AppTest2 test2 = new AppTest2();
    }
}
