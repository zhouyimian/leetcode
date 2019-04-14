package com.km.WeeklyContest132;

public class Divisor_Game {
    public boolean divisorGame(int N) {
        boolean[] ans = new boolean[1001];
        ans[0] = false;
        ans[1] = false;
        ans[2] = true;
        ans[3] = false;
        for(int i = 4;i<=1000;i++){
            deal(i,ans);
        }
        return ans[N];
    }
    public void deal(int num,boolean[] ans){
        for(int i = 1;i<num;i++){
            if(num%i==0&&!ans[num-i]){
                ans[num] = true;
                return;
            }
        }
        ans[num] = false;
    }
}
