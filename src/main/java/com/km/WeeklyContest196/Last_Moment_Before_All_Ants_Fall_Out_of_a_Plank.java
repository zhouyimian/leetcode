package com.km.WeeklyContest196;

import java.util.Arrays;

public class Last_Moment_Before_All_Ants_Fall_Out_of_a_Plank {
    public int getLastMoment(int n, int[] left, int[] right) {
        int ans = 0;
        if(left.length!=0){
            Arrays.sort(left);
            ans = left[left.length-1];
        }
        if(right.length!=0){
            Arrays.sort(right);
            ans = Math.max(ans,n-right[0]);
        }
        return ans;
    }
}
