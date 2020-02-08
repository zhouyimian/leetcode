package com.Biweekly.BiweeklyContest19;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jump_Game_IV {
    public int minJumps(int[] arr) {
        int length = arr.length;
        if(length<=1)
            return 0;
        int ans = 0;
        Map<Integer,List<Integer>> index = new HashMap<>();
        for(int i = 0;i<length;i++){
            List<Integer> list = index.getOrDefault(arr[i],new ArrayList<>());
            list.add(i);
            index.put(arr[i],list);
        }
        boolean[] vis = new boolean[length];
        vis[0] = true;
        List<Integer> queue = new ArrayList<>();
        queue.add(0);
        while (queue.size()!=0){
            List<Integer> temp = new ArrayList<>();
            for(int i = 0;i<queue.size();i++){
                int cur = queue.get(i);
                if(cur-1>=0&&!vis[cur-1]){
                    temp.add(cur-1);
                    vis[cur-1] = true;
                }
                if(cur+1<length&&!vis[cur+1]){
                    if(cur+1==length-1){
                        return ans+1;
                    }else{
                        temp.add(cur+1);
                        vis[cur+1] = true;
                    }
                }
                List<Integer> list = index.get(arr[cur]);
                if(list==null)
                    continue;
                for(int j = 0;j<list.size();j++){
                    if(!vis[list.get(j)]){
                        if(list.get(j)==length-1)
                            return ans+1;
                        temp.add(list.get(j));
                        vis[list.get(j)] = true;
                    }
                }
                index.remove(arr[cur]);
            }
            queue.clear();
            queue.addAll(temp);
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Jump_Game_IV test = new Jump_Game_IV();
        int[] arr = {11,22,7,7,7,7,7,7,7,22,13};
        System.out.println(test.minJumps(arr));
    }
}
