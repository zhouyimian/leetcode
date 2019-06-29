package com.km.problem1_10;

public class Longest_Palindromic_Substring {
    public String longestPalindrome(String s) {
        String ans = "";
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        for(int i = length-1;i>=0;i--){
            for(int j = i;j<length;j++){
                dp[i][j] = s.charAt(i)==s.charAt(j)&&(j-i<3||dp[i+1][j-1]);
                if(dp[i][j]&&(ans==null||ans.length()<(j-i+1)))
                    ans = s.substring(i,j+1);
            }
        }
        return ans;
    }
}
