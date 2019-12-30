package com.km.WeeklyContest169;

import java.util.ArrayList;
import java.util.List;

public class Jump_Game_III {
    public boolean canReach(int[] arr, int start) {
        List<Integer> queue = new ArrayList<>();
        boolean[] vis = new boolean[arr.length];
        queue.add(start);
        while (queue.size()!=0){
            List<Integer> temp = new ArrayList<>();
            for(int i = 0;i<queue.size();i++){
                int cur = queue.get(i);
                if(check(cur+arr[cur],vis)){
                    temp.add(cur+arr[cur]);
                    vis[cur+arr[cur]] = true;
                }
                if(check(cur-arr[cur],vis)){
                    temp.add(cur-arr[cur]);
                    vis[cur-arr[cur]] = true;
                }
            }
            queue.clear();
            queue.addAll(temp);
        }
        for(int i = 0;i<arr.length;i++){
            if(arr[i]==0&&vis[i])
                return true;
        }
        return false;
    }

    private boolean check(int cur, boolean[] vis) {
        if(cur<0||cur>=vis.length||vis[cur])
            return false;
        return true;
    }

    public static void main(String[] args) {
        Jump_Game_III test = new Jump_Game_III();
        int[] arr = {0,3,0,6,3,3,4};
        System.out.println(test.canReach(arr,6));
    }
}
//[]
//6