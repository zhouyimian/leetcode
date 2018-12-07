package com.km.leetcode;

public class Palindrome_Partitioning_II {
    public int minCut(String s) {
        int ans=s.length();
        int len=s.length();
        boolean[][] dp=new boolean[len][len];
        int[] cut=new int[len];
        for(int i=0;i<len;i++){
            int min=i;
            for(int j=0;j<=i;j++){
                if(s.charAt(i)==s.charAt(j)&&(j>i-2||dp[j+1][i-1])){
                    dp[j][i]=true;
                    if(j==0)
                        min=0;
                    else
                        min=Math.min(min,cut[j-1]+1);
                }
            }
            cut[i]=min;
        }
        return cut[len-1];
    }

    public static void main(String[] args) {
        Palindrome_Partitioning_II test=new Palindrome_Partitioning_II();
        System.out.println(test.minCut("aa"));
    }
}
