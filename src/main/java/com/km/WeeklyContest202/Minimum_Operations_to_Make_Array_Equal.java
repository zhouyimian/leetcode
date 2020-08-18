package com.km.WeeklyContest202;

public class Minimum_Operations_to_Make_Array_Equal {
    public int minOperations(int n) {
        if(n%2==1){
            return n*(n+1)/4;
        }else{
            return n*n/4;
        }
    }
}
