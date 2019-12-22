package com.km.WeeklyContest168;

public class Find_Numbers_with_Even_Number_of_Digits {
    public int findNumbers(int[] nums) {
        int ans = 0;
        for(int num:nums){
            String s = num+"";
            ans+=s.length()%2==0?1:0;
        }
        return ans;
    }
}
