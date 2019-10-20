package com.km.WeeklyContest158;

public class Dice_Roll_Simulation {
    public int dieSimulator(int n, int[] rollMax) {
        long ans = 0;
        int MOD = 1000000007;
        int[][][] dp = new int[n+1][7][16];
        for(int i = 1;i<=6;i++){
            dp[1][i][1] = 1;
            dp[1][i][0] = 1;
        }
        for(int i = 2;i<=n;i++){
            for(int j = 1;j<=6;j++){
                for(int k = 1;k<=rollMax[j-1];k++) {
                    dp[i][j][k] += dp[i - 1][j][k - 1];
                    dp[i][j][k]%=MOD;
                }
            }
        }
        for(int i = 1;i<=6;i++){
            for(int j = 0;j<=rollMax[j];j++) {
                ans += dp[n][i][j];
                ans%=MOD;
            }
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        Dice_Roll_Simulation t = new Dice_Roll_Simulation();
        int[] nums = {1,1,2,2,2,3};
        System.out.println(t.dieSimulator(2,nums));
    }
}
