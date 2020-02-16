package com.km.WeeklyContest176;

public class Construct_Target_Array_With_Multiple_Sums {
    public boolean isPossible(int[] target) {
        int max = 0;
        int index = 0;
        for(int i= 0 ;i < target.length ;i++){
            if(max < target[i]){
                max = target[i];
                index = i;
            }
        }
        if(max == 1)return true;
        for(int i= 0;i<target.length;i++){
            if(i == index)continue;
            if(target[i] > max)return false;
            max-=target[i];
        }
        target[index] = max;
        return isPossible(target);
    }
}
