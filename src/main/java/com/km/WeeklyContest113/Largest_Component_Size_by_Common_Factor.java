package com.km.WeeklyContest113;

import java.util.*;

public class Largest_Component_Size_by_Common_Factor {
    int N=100010;
    int[] parent;
    int[] count;
    int len;
    public int largestComponentSize(int[] A) {
        len=A.length;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int num : A) {
            int temp = num;
            for (int i = 2; i * i <= num; i++) {
                if (temp % i == 0) {
                    while (temp % i == 0) temp /= i;
                    map.putIfAbsent(i,new HashSet<>());
                    map.get(i).add(num);
                }
            }
            if (temp > 1) {
                map.putIfAbsent(temp,new HashSet<>());
                map.get(temp).add(num);
            }
        }
        parent=new int[N];
        count=new int[N];
        for(int i=0;i<N;i++) parent[i]=i;
        Arrays.fill(count,1);
        int ans=1;
        for(Set<Integer> set:map.values()){
            int x=set.iterator().next();
            for(int y:set){
                union(x,y);
                ans=Math.max(ans,count[find(x)]);
            }
        }
        return ans;
    }

    private void union(int x, int y) {
        int parent_x=find(x);
        int parent_y=find(y);
        if(parent_x!=parent_y){
            parent[parent_x]=parent_y;
            count[parent_y]+=count[parent_x];
        }
    }

    private int find(int x) {
        if(x==parent[x])
            return x;
        return parent[x]=find(parent[x]);
    }

    public static void main(String[] args) {
        int[] nums={98,70,6,9,10,46,47,16,19,55,57,29,94,95};
        Largest_Component_Size_by_Common_Factor test=new Largest_Component_Size_by_Common_Factor();
        System.out.println(test.largestComponentSize(nums));
    }
}
