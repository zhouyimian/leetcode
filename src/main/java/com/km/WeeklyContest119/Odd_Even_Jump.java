package com.km.WeeklyContest119;

import java.util.TreeMap;

public class Odd_Even_Jump {
    public int oddEvenJumps(int[] A) {
        int n=A.length,res=1;
        boolean[] higher=new boolean[n],lower=new boolean[n];
        higher[n-1]=lower[n-1]=true;
        TreeMap<Integer,Integer> map=new TreeMap<>();
        map.put(A[n-1],n-1);
        for(int i=n-2;i>=0;i--){
            Integer hi=map.ceilingKey(A[i]),lo=map.floorKey(A[i]);
            if(hi!=null) higher[i]=lower[map.get(hi)];
            if(lo!=null) lower[i]=higher[map.get(lo)];
            if(higher[i]) res++;
            map.put(A[i],i);
        }
        return res;
    }
}
