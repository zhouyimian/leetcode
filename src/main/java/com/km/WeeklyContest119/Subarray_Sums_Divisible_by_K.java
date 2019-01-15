package com.km.WeeklyContest119;

import java.util.HashMap;
import java.util.Map;

public class Subarray_Sums_Divisible_by_K {
    public int subarraysDivByK(int[] A, int K) {
        int ans=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int sum=0;
        for(int num:A){
            sum = (sum+num%K+K)%K;
            ans+=map.getOrDefault(sum,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}
