package com.km.WeeklyContest141;

public class Shortest_Common_Supersequence {
    public String shortestCommonSupersequence(String str1, String str2) {
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for(int i = 0;i<=str1.length();i++){
            dp[i][0] = i;
        }
        for(int i = 0;i<=str2.length();i++){
            dp[0][i] = i;
        }
        for(int i = 1;i<=str1.length();i++){
            for(int j = 1;j<=str2.length();j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int index1 = str1.length();
        int index2 = str2.length();
        while(index1!=0||index2!=0){
            if(index1==0){
                sb.append(str2.charAt(--index2));
                continue;
            }
            if(index2==0){
                sb.append(str1.charAt(--index1));
                continue;
            }
            if(str1.charAt(index1-1)==str2.charAt(index2-1)){
                sb.append(str1.charAt(index1-1));
                index1--;
                index2--;
            }else if(dp[index1-1][index2]<dp[index1][index2-1]){
                sb.append(str1.charAt(index1-1));
                index1--;
            }else{
                sb.append(str2.charAt(index2-1));
                index2--;
            }
        }
        return sb.reverse().toString();
    }


    public static void main(String[] args) {
        String A = "bbbaaaba";
        String B = "bbababbb";
        Shortest_Common_Supersequence test = new Shortest_Common_Supersequence();
//        System.out.println(A.substring(A.length()-1,A.length()));
//        System.out.println(B.substring(0,0));
        System.out.println(test.shortestCommonSupersequence(A,B));
    }
}
