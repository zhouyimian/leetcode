package com.km.WeeklyContest175;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Check_If_N_and_Its_Double_Exist {
    public boolean checkIfExist(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:arr)
            map.put(num,map.getOrDefault(num,0)+1);
        for(int num:arr){
            if(num==0){
                if(map.get(0)>1)
                    return true;
            }else {
                if(map.containsKey(num*2))
                    return true;
            }
        }
        return false;
    }
}
