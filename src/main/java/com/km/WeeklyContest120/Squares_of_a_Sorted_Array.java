package com.km.WeeklyContest120;

import java.util.*;

public class Squares_of_a_Sorted_Array {
    public int[] sortedSquares(int[] A) {
        List<Integer> list = new ArrayList<>();
        for(int num:A)
            list.add(num*num);
        Collections.sort(list);
        for(int i=0;i<A.length;i++)
            A[i]=list.get(i);
        return A;
    }
}
