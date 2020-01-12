package com.km.WeeklyContest171;

public class Convert_Integer_to_the_Sum_of_Two_No_Zero_Integers {
    public int[] getNoZeroIntegers(int n) {
        int[] ans = new int[2];
        for(int i = 1;i<n;i++){
            if(check(i)&&check(n-i)){
                ans[0] = i;
                ans[1] = n-i;
                return ans;
            }
        }
        return ans;
    }

    private boolean check(int num) {
        while (num!=0){
            if(num%10==0)
                return false;
            num/=10;
        }
        return true;
    }
}
