package com.km.WeeklyContest125;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class Find_the_Town_Judge {
    public int findJudge(int N, int[][] trust) {
        if(N==1)
            return 1;
        Map<Integer,HashSet<Integer>> betrust = new HashMap<>();
        Map<Integer,HashSet<Integer>> trusts = new HashMap<>();
        for(int i = 0;i<trust.length;i++){
            if(betrust.get(trust[i][1])==null)
                betrust.put(trust[i][1],new HashSet<Integer>());
            betrust.get(trust[i][1]).add(trust[i][0]);
            if(trusts.get(trust[i][0])==null)
                trusts.put(trust[i][0],new HashSet<Integer>());
            trusts.get(trust[i][0]).add(trust[i][1]);
        }
        Iterator<Integer> it = betrust.keySet().iterator();
        while(it.hasNext()){
            Integer key = it.next();
            if(betrust.get(key).size()==N-1&&trusts.get(key)==null)
                return key;
        }
        return -1;
    }
}
