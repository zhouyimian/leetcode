package com.km.WeeklyContest123;

import jdk.nashorn.internal.ir.IfNode;

import java.util.HashMap;
import java.util.Map;

public class Subarrays_with_K_Different_Integers {
    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostK(A, K) - atMostK(A, K - 1);
    }

    private int atMostK(int[] a, int k) {
        int first = 0,ans =0;
        Map<Integer,Integer> map =new HashMap<>();
        for(int i = 0;i<a.length;i++){
            map.put(a[i],map.getOrDefault(a[i],0)+1);
            while(map.size()>k){
                if(map.get(a[first])==1)
                    map.remove(a[first]);
                else
                    map.put(a[first],map.get(a[first])-1);
                first++;
            }
            ans+=i-first+1;
        }
        return ans;
    }
}
