package com.km.WeeklyContest123;

import java.util.HashMap;
import java.util.Map;

public class Satisfiability_of_Equality_Equations {
    public boolean equationsPossible(String[] equations) {
        int count = 0;
        Map<Character,Integer> index = new HashMap<>();
        for(String s : equations){
            if(index.get(s.charAt(0))==null)
                index.put(s.charAt(0),count++);
            if(index.get(s.charAt(3))==null)
                index.put(s.charAt(3),count++);
            if(s.charAt(0)==s.charAt(3)&&s.charAt(1)=='!')
                return false;
        }
        int[] map =new int[count];
        for(int i = 0;i<count;i++)
            map[i]=i;
        for(String s : equations){
            if(s.charAt(1)=='='){
                int parentA = findParent(map,index.get(s.charAt(0)));
                int parentB = findParent(map,index.get(s.charAt(3)));
                map[parentB]=parentA;
            }
        }
        for(String s: equations){
            if(s.charAt(1)=='!'){
                int parentA = findParent(map,index.get(s.charAt(0)));
                int parentB = findParent(map,index.get(s.charAt(3)));
                if(parentA==parentB)
                    return false;
            }
        }
        return true;
    }

    private int findParent(int[] map, int point) {
        if(map[point]!=point)
            return map[point]=findParent(map,map[point]);
        else
            return point;
    }
}
