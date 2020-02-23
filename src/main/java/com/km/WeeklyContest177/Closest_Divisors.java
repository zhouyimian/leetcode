package com.km.WeeklyContest177;

public class Closest_Divisors {
    public int[] closestDivisors(int num) {
        int[] temp1 = cal(num+1);
        int[] temp2 = cal(num+2);
        int diff1 = Math.abs(temp1[0]-temp1[1]);
        int diff2 = Math.abs(temp2[0]-temp2[1]);
        if(diff1<diff2)
            return temp1;
        return temp2;
    }

    private int[] cal(int target) {
        int[] ans = new int[2];
        for(int i = (int) Math.sqrt(target);i>=1;i--){
            if(target%i==0){
                ans[0] = i;
                ans[1] = target/i;
                return ans;
            }
        }
        return ans;
    }
}
