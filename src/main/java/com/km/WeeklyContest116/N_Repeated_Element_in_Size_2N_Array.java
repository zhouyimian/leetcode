package com.km.WeeklyContest116;

import java.util.Set;
import java.util.TreeSet;

public class N_Repeated_Element_in_Size_2N_Array {
    public int repeatedNTimes(int[] A) {
        Set<Integer> set=new TreeSet<>();
        for(int num:A){
            if(set.contains(num))
                return num;
            else
                set.add(num);
        }
        return 0;
    }
}
