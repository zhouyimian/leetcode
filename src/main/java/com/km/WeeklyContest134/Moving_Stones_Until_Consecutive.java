package com.km.WeeklyContest134;

import java.util.Arrays;

public class Moving_Stones_Until_Consecutive {
    public int[] numMovesStones(int a, int b, int c) {
        int[] nums = new int[3];
        nums[0]=a;
        nums[1]=b;
        nums[2]=c;
        Arrays.sort(nums);
        a = nums[0];
        b = nums[1];
        c = nums[2];
        int diff1 = b-a;
        int diff2 = c-b;
        int[] ans = new int[2];
        if(diff1==1&&diff2==1){
            ans[0] = 0;
        }else if(diff1==1||diff2==1||diff1==2||diff2==2){
            ans[0] = 1;
        }else{
            ans[0] = 2;
        }
        ans[1] = diff1+diff2-2;
        return ans;
    }
}
