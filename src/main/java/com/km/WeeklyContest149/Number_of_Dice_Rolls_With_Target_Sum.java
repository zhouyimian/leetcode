package com.km.WeeklyContest149;

public class Number_of_Dice_Rolls_With_Target_Sum {
    public int numRollsToTarget(int d, int f, int target) {
        int mod = 1000000007;
        int[][]dp = new int[31][1001];
        for(int i = 1;i<=f;i++)
            dp[1][i] = 1;
        for(int i = 1;i<=d;i++){
            for(int j = 1;j<=target;j++){
                for(int k=1;k<=j&&k<=f;k++){
                    dp[i][j] = (dp[i][j]+dp[i-1][j-k])%mod;
                }
            }
        }
        return dp[d][target];
    }

    public static void main(String[] args) {
        Number_of_Dice_Rolls_With_Target_Sum test = new Number_of_Dice_Rolls_With_Target_Sum();
        System.out.println(test.numRollsToTarget(30,30,500));
    }
}
